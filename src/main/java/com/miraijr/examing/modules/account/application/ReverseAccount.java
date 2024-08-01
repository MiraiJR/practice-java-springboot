package com.miraijr.examing.modules.account.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.core.domain.acount.Account;
import com.miraijr.examing.modules.account.application.exceptions.AccountNotFoundException;
import com.miraijr.examing.modules.account.application.port.in.ReverseAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.event.ReverseAccountEvent;
import com.miraijr.examing.modules.account.application.port.out.DeleteAccountPort;
import com.miraijr.examing.modules.account.application.port.out.LoadAccountPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReverseAccount implements ReverseAccountUseCase {
  private final LoadAccountPort loadAccountPort;
  private final DeleteAccountPort deleteAccountPort;

  @Override
  @Transactional("transactionManager")
  public void execute(ReverseAccountEvent reverseAccountEvent) {
    Optional<Account> matchedAccount = this.loadAccountPort.loadAccountById(reverseAccountEvent.getAccountId());
    if (matchedAccount.isEmpty()) {
      throw new AccountNotFoundException();
    }
    this.deleteAccountPort.deleteAccount(matchedAccount.get().getId());
  }
}
