package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.examing.modules.account.application.port.in.ReverseAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.ReverseAccountEvent;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;
import com.miraijr.examing.modules.account.application.port.out.UpdateAccountPort;
import com.miraijr.examing.modules.account.common.types.enums.AccountStatus;
import com.miraijr.examing.modules.account.domain.Account;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReverseAccount implements ReverseAccountUseCase {
  private final UpdateAccountPort updateAccountPort;
  private final LoadAccountPort loadAccountPort;

  @Override
  @Transactional("transactionManager")
  public void execute(ReverseAccountEvent reverseAccountEvent) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountById(reverseAccountEvent.getAccountId());
    if (matchedAccount.isEmpty()) {
      throw new AccountNotFoundException();
    }

    matchedAccount.get().updateStatus(AccountStatus.FAILED.toString());
    this.updateAccountPort.updateAccount(matchedAccount.get());
  }
}
