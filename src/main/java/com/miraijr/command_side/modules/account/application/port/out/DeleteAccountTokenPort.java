package com.miraijr.command_side.modules.account.application.port.out;

public interface DeleteAccountTokenPort {
  public void deleteByAccessToken(String token);

  public void deleteByRefreshToken(String token);

  public void deleteById(Long tokenId);
}
