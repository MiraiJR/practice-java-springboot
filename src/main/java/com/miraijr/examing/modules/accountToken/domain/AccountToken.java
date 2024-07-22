package com.miraijr.examing.modules.accountToken.domain;

import com.miraijr.examing.modules.account.domain.Account;

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
