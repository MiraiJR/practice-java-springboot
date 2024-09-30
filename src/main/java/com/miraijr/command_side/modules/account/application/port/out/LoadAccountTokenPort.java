package com.miraijr.command_side.modules.account.application.port.out;

import java.util.List;
import java.util.Optional;

import com.miraijr.command_side.core.domain.acount.AccountToken;

public interface LoadAccountTokenPort {
  public List<AccountToken> loadTokensByAccount(Long accountId);

  public Optional<AccountToken> loadTokenByAccessToken(String token);

  public Optional<AccountToken> loadTokenByRefreshToken(String token);
}
