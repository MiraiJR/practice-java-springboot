package com.miraijr.command_side.modules.user.application.port.in.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserInputModel {
  private Long id;
  private String fullName;
}
