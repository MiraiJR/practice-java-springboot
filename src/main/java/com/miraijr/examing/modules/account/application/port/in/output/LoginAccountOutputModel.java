package com.miraijr.examing.modules.account.application.port.in.output;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginAccountOutputModel {
  private String accessToken;
  private String refreshToken;
}
