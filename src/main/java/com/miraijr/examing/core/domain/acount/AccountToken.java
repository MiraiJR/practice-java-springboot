package com.miraijr.examing.core.domain.acount;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountToken {
  protected Long id;
  protected String accessToken;
  protected String refreshToken;
  protected Device device;
  protected Long accountId;
}
