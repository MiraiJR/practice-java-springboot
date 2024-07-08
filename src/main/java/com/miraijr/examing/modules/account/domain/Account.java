package com.miraijr.examing.modules.account.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
  private final Long id;
  private final LocalDateTime createdAt;
  private final String username;
  private final Password password;
  private final String accessToken;
  private final String refreshToken;
  private final LocalDateTime latestLogin;

  public void hashPassword() {
    this.password.hash();
  }
}
