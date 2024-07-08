package com.miraijr.examing.account.application.port.out;

import java.util.Optional;

import com.miraijr.examing.account.domain.Account;

public interface LoadAccountPort {
  public Optional<Account> loadAccountByUsername(String username);
}
