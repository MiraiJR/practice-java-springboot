package com.miraijr.command_side.modules.account.application.port.out;

import com.miraijr.command_side.core.domain.acount.Account;

public interface CreateAccountPort {
  public Long createAccount(Account account);
}
