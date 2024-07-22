package com.miraijr.examing.modules.account.application.port.out.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountTokenInputModel {
  private String accessToken;
  private String refreshToken;
  private String device;
  private Long accountId;
}
