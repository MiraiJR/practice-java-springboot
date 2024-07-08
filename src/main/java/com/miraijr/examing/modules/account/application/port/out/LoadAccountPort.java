package com.miraijr.examing.modules.account.application.port.out;

import java.util.Optional;

import com.miraijr.examing.modules.account.domain.Account;

public interface LoadAccountPort {
  public Optional<Account> loadAccountByUsername(String username);
}
