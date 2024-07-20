package com.miraijr.examing.core.infrastruction.external_services.out;

import com.miraijr.examing.shared.types.enums.TokenType;

public interface TokenHandlerPort {
  public Long extractUserId(String token, TokenType type);

  public String generateToken(Long userId, TokenType type);

  public boolean isTokenExpired(String token, TokenType type);
}
