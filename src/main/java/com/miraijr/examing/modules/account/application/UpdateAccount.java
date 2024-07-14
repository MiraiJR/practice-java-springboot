package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.examing.modules.account.application.port.in.UpdateAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.ChangeAccountStatusInputModel;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.modules.account.domain.Account;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateAccount implements UpdateAccountUseCase {
  private LoadAccountPort loadAccountPort;
  private UpdateAccountPort updateAccountPort;

  @Override
  public void changeStatusAccount(ChangeAccountStatusInputModel changeAccountStatusInputModel) {
    Optional<Account> matchedAccount = this.loadAccountPort
        .loadAccountById(changeAccountStatusInputModel.getAccountId());

    if (matchedAccount.isEmpty() || matchedAccount.get().getStatus().isFailed()) {
      throw new AccountNotFoundException();
    }

    matchedAccount.get().updateStatus(changeAccountStatusInputModel.getAccountStatus().toString());
    this.updateAccountPort.updateAccount(matchedAccount.get());
  }
}
