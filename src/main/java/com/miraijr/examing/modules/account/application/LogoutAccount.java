package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.examing.modules.account.application.port.in.LogoutAccountUseCase;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.modules.account.domain.Account;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LogoutAccount implements LogoutAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final UpdateAccountPort updateAccountPort;

  @Override
  @Transactional("transactionManager")
  public String execute(Long accountId) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountById(accountId);

    if (matchedAccount.isEmpty()) {
      throw new AccountNotFoundException();
    }

    matchedAccount.get().updateAccessToken(null);
    matchedAccount.get().updateRefreshToken(null);
    this.updateAccountPort.updateAccount(matchedAccount.get());
    return "Logout successfully!";
  }
}
