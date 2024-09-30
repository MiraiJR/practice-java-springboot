package com.miraijr.command_side.core.infrastruction.external_services.out;

import com.miraijr.command_side.shared.types.enums.TokenType;

public interface TokenHandlerPort {
  public Long extractUserId(String token, TokenType type);

  public String generateToken(Long userId, TokenType type);

  public boolean isTokenExpired(String token, TokenType type);
}
