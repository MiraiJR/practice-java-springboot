package com.miraijr.examing.account.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
  private final Long id;
  private final LocalDateTime createdAt;
  private final String username;
  private final String password;
  private final String accessToken;
  private final String refreshToken;
  private final LocalDateTime latestLogin;
}
