package com.miraijr.command_side.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.command_side.core.domain.acount.Account;
import com.miraijr.command_side.core.domain.acount.Password;
import com.miraijr.command_side.core.domain.acount.Status;
import com.miraijr.command_side.modules.account.application.exceptions.FailToRegisterAccountException;
import com.miraijr.command_side.modules.account.application.exceptions.UsernameExistedException;
import com.miraijr.command_side.modules.account.application.port.in.RegisterAccountUseCase;
import com.miraijr.command_side.modules.account.application.port.in.input.RegisterAccountInputModel;
import com.miraijr.command_side.modules.account.application.port.out.CreateAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.command_side.modules.account.application.port.out.input.CreateUserInputModel;
import com.miraijr.command_side.modules.account.common.types.enums.AccountStatus;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RegisterAccount implements RegisterAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final CreateAccountPort createAccountPort;
  private final SendEventToMessageQueuePort sendMessageToKafkaPort;

  @Override
  @Transactional("transactionManager")
  public String execute(RegisterAccountInputModel registerAccountInputModel) {
    Account account = Account.builder()
        .username(registerAccountInputModel.getUsername())
        .password(new Password(registerAccountInputModel.getPassword()))
        .status(new Status(AccountStatus.PENDING.toString()))
        .build();
    account.hashPassword();

    Optional<Account> matchedAccount = this.loadAccountPort
        .loadAccountByUsername(registerAccountInputModel.getUsername());

    if (matchedAccount.isPresent()) {
      throw new UsernameExistedException();
    }

    Long newAccountId = this.createAccountPort.createAccount(account);

    matchedAccount = this.loadAccountPort
        .loadAccountById(newAccountId);
    if (matchedAccount.isEmpty() || matchedAccount.get().getStatus().isFailed()) {
      throw new FailToRegisterAccountException();
    }

    this.sendMessageToKafkaPort.sendCreateUserFromAccountTopic(
        new CreateUserInputModel(matchedAccount.get().getId(), registerAccountInputModel.getFullName()));

    return "Create account successfully";
  }
}
