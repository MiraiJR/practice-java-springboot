package com.miraijr.examing.modules.account.application.port.out;

public interface SignTokenPort {
  public String signAccessToken(Long accountId);

  public String signRefreshToken(Long accountId);
}
