package com.miraijr.examing.modules.account.application.port.out;

import com.miraijr.examing.modules.account.domain.Account;

public interface CreateAccountPort {
  public Long createAccount(Account account);
}
