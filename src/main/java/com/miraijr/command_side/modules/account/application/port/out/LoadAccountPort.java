package com.miraijr.command_side.modules.account.application.port.out;

import java.util.Optional;

import com.miraijr.command_side.core.domain.acount.Account;

public interface LoadAccountPort {
  public Optional<Account> loadAccountByUsername(String username);

  public Optional<Account> loadAccountById(Long accountId);
}
