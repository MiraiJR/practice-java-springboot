package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.exceptions.FailToRegisterAccountException;
import com.miraijr.examing.modules.account.application.exceptions.UsernameExistedException;
import com.miraijr.examing.modules.account.application.port.in.RegisterAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.RegisterAccountInputModel;
import com.miraijr.examing.modules.account.application.port.out.CreateAccountPort;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.SendMessageToKafkaPort;
import com.miraijr.examing.modules.account.application.port.out.input.CreateUserInputModel;
import com.miraijr.examing.modules.account.domain.Account;
import com.miraijr.examing.modules.account.domain.Password;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RegisterAccount implements RegisterAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final CreateAccountPort createAccountPort;
  private final SendMessageToKafkaPort sendMessageToKafkaPort;

  @Override
  public String execute(RegisterAccountInputModel registerAccountInputModel) {
    Account account = Account.builder()
        .username(registerAccountInputModel.getUsername())
        .password(new Password(registerAccountInputModel.getPassword()))
        .build();
    account.hashPassword();

    Optional<Account> matchedAccount = this.loadAccountPort
        .loadAccountByUsername(registerAccountInputModel.getUsername());

    if (matchedAccount.isPresent()) {
      throw new UsernameExistedException();
    }

    this.createAccountPort.createAccount(account);

    matchedAccount = this.loadAccountPort
        .loadAccountByUsername(registerAccountInputModel.getUsername());
    if (matchedAccount.isEmpty()) {
      throw new FailToRegisterAccountException();
    }
    this.sendMessageToKafkaPort.sendCreateUserFromAccountTopic(
        new CreateUserInputModel(matchedAccount.get().getId(), registerAccountInputModel.getFullName()));

    return "Create account successfully";
  }
}
