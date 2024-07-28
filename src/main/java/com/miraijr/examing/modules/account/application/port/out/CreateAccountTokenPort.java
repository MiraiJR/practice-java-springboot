package com.miraijr.examing.modules.account.application.port.out;

import com.miraijr.examing.modules.account.domain.AccountToken;

public interface CreateAccountTokenPort {
  public void createAccountToken(AccountToken accountToken);
}
