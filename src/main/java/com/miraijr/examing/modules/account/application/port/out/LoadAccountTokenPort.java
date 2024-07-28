package com.miraijr.examing.modules.account.application.port.out;

import java.util.List;
import java.util.Optional;

import com.miraijr.examing.modules.account.domain.AccountToken;

public interface LoadAccountTokenPort {
  public List<AccountToken> loadTokensByAccount(Long accountId);

  public Optional<AccountToken> loadTokenByAccessToken(String token);

  public Optional<AccountToken> loadTokenByRefreshToken(String token);
}
