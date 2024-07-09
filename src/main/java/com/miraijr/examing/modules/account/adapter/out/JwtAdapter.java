package com.miraijr.examing.modules.account.adapter.out;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.port.out.SignTokenPort;
import com.miraijr.examing.shared.configs.services.JwtService;
import com.miraijr.examing.shared.types.enums.TokenType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAdapter implements SignTokenPort {
  private final JwtService jwtService;

  @Override
  public String signAccessToken(Long accountId) {
    return jwtService.generateToken(accountId, TokenType.ACCESS);
  }

  @Override
  public String signRefreshToken(Long accountId) {
    return jwtService.generateToken(accountId, TokenType.REFRESH);
  }
}
