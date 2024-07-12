package com.miraijr.examing.modules.user.application.port.in.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserInputModel {
  private Long id;
  private String fullName;
}
