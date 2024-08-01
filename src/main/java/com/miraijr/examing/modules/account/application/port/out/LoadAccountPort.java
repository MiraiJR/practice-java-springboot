package com.miraijr.examing.modules.account.application.port.out;

import java.util.Optional;

import com.miraijr.examing.core.domain.acount.Account;

public interface LoadAccountPort {
  public Optional<Account> loadAccountByUsername(String username);

  public Optional<Account> loadAccountById(Long accountId);
}
