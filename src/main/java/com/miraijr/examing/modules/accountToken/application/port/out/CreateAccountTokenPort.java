package com.miraijr.examing.modules.accountToken.application.port.out;

import com.miraijr.examing.modules.accountToken.domain.AccountToken;

public interface CreateAccountTokenPort {
  public void createAccountToken(AccountToken accountToken);
}
