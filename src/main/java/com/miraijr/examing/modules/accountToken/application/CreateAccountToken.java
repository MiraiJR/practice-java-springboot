package com.miraijr.examing.modules.accountToken.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.domain.Account;
import com.miraijr.examing.modules.accountToken.application.port.in.CreateAccountTokenUseCase;
import com.miraijr.examing.modules.accountToken.application.port.in.input.CreateAccountTokenInputModel;
import com.miraijr.examing.modules.accountToken.application.port.out.CreateAccountTokenPort;
import com.miraijr.examing.modules.accountToken.domain.AccountToken;
import com.miraijr.examing.modules.accountToken.domain.Device;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateAccountToken implements CreateAccountTokenUseCase {
  private final CreateAccountTokenPort createAccountTokenPort;
  private final LoadAccountPort loadAccountPort;

  @Override
  @Transactional("transactionManager")
  public void execute(CreateAccountTokenInputModel inputModel) {
    Optional<Account> matchedAccount = this.loadAccountPort
        .loadAccountById(inputModel.getAccountId());

    if (matchedAccount.isEmpty()) {
      return;
    }

    AccountToken accountToken = AccountToken.builder()
        .accessToken(inputModel.getAccessToken())
        .refreshToken(inputModel.getRefreshToken())
        .account(matchedAccount.get())
        .device(new Device(inputModel.getDevice()))
        .build();

    this.createAccountTokenPort.createAccountToken(accountToken);
  }
}
