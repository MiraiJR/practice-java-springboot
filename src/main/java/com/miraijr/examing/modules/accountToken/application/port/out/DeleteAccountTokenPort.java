package com.miraijr.examing.modules.accountToken.application.port.out;

public interface DeleteAccountTokenPort {
  public void deleteByAccessToken(String token);

  public void deleteByRefreshToken(String token);

  public void deleteById(Long tokenId);
}
