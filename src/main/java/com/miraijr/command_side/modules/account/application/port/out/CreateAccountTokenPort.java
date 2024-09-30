package com.miraijr.command_side.modules.account.application.port.out;

import com.miraijr.command_side.core.domain.acount.AccountToken;

public interface CreateAccountTokenPort {
  public void createAccountToken(AccountToken accountToken);
}
