package com.miraijr.examing.modules.account.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountToken {
  private Long id;
  private String accessToken;
  private String refreshToken;
  private Device device;
  private Account account;
}
