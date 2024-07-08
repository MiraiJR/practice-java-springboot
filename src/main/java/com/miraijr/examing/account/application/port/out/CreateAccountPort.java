package com.miraijr.examing.account.application.port.out;

import com.miraijr.examing.account.domain.Account;

public interface CreateAccountPort {
  public void createAccount(Account account);
}
