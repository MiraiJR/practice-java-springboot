package com.miraijr.examing.modules.account.application.port.out;

import com.miraijr.examing.core.domain.acount.AccountToken;

public interface CreateAccountTokenPort {
  public void createAccountToken(AccountToken accountToken);
}
