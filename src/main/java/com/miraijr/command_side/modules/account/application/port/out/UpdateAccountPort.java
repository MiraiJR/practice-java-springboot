package com.miraijr.command_side.modules.account.application.port.out;

import com.miraijr.command_side.core.domain.acount.Account;

public interface UpdateAccountPort {
  public void updateAccount(Account account);
}
