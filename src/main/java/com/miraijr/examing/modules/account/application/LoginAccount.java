package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.core.domain.acount.Account;
import com.miraijr.examing.core.domain.acount.AccountToken;
import com.miraijr.examing.core.domain.acount.Device;
import com.miraijr.examing.modules.account.application.exceptions.WrongInforLoginException;
import com.miraijr.examing.modules.account.application.port.in.LoginAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.LoginAccountInputModel;
import com.miraijr.examing.modules.account.application.port.in.output.LoginAccountOutputModel;
import com.miraijr.examing.modules.account.application.port.out.CreateAccountTokenPort;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.SignTokenPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.shared.types.enums.DeviceType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoginAccount implements LoginAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final SignTokenPort signTokenPort;
  private final UpdateAccountPort updateAccountPort;
  private final CreateAccountTokenPort createAccountTokenPort;

  @Override
  @Transactional("transactionManager")
  public LoginAccountOutputModel execute(LoginAccountInputModel loginAccountInputModel) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountByUsername(loginAccountInputModel.getUsername());

    if (matchedAccount.isEmpty()
        || (matchedAccount.isPresent() && !matchedAccount.get().verifyPassword(loginAccountInputModel.getPassword()))) {
      throw new WrongInforLoginException();
    }

    String accessToken = this.signTokenPort.signAccessToken(matchedAccount.get().getId());
    String refreshToken = this.signTokenPort.signRefreshToken(matchedAccount.get().getId());
    matchedAccount.get().updateLatestLogin();
    this.updateAccountPort.updateAccount(matchedAccount.get());
    this.createAccountToken(accessToken, refreshToken, DeviceType.OTHER.name(), matchedAccount.get());
    return new LoginAccountOutputModel(accessToken, refreshToken);
  }

  private void createAccountToken(String accessToken, String refreshToken, String device, Account account) {
    AccountToken accountToken = AccountToken.builder()
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .accountId(account.getId())
        .device(new Device(device))
        .build();

    this.createAccountTokenPort.createAccountToken(accountToken);
  }
}
