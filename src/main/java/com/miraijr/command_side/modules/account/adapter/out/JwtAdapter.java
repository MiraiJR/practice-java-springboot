package com.miraijr.command_side.modules.account.adapter.out;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.infrastruction.external_services.JwtService;
import com.miraijr.command_side.modules.account.application.port.out.SignTokenPort;
import com.miraijr.command_side.shared.types.enums.TokenType;

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
