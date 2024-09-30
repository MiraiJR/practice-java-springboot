package com.miraijr.command_side.modules.account.application.port.out;

public interface SignTokenPort {
  public String signAccessToken(Long accountId);

  public String signRefreshToken(Long accountId);
}
