package com.miraijr.command_side.modules.account.application;

import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.command_side.core.domain.acount.Account;
import com.miraijr.command_side.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.command_side.modules.account.application.port.in.LogoutAccountUseCase;
import com.miraijr.command_side.modules.account.application.port.out.DeleteAccountTokenPort;
import com.miraijr.command_side.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.command_side.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.command_side.shared.types.CustomAuthentication;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LogoutAccount implements LogoutAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final UpdateAccountPort updateAccountPort;
  private final DeleteAccountTokenPort deleteAccountTokenPort;

  @Override
  @Transactional("transactionManager")
  public String execute(Long accountId) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountById(accountId);

    if (matchedAccount.isEmpty()) {
      throw new AccountNotFoundException();
    }

    Long tokenId = this.getTokenId();
    this.updateAccountPort.updateAccount(matchedAccount.get());
    this.deleteAccountTokenById(tokenId);

    return "Logout successfully!";
  }

  private Long getTokenId() {
    CustomAuthentication authentication = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();

    Long tokenId = (Long) authentication.getTokenId();
    return tokenId;
  }

  private void deleteAccountTokenById(Long tokenId) {
    this.deleteAccountTokenPort.deleteById(tokenId);
  }
}
