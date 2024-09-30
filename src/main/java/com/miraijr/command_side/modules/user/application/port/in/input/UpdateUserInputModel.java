package com.miraijr.command_side.modules.user.application.port.in.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserInputModel {
  @NotNull
  @NotEmpty
  private String fullName;
  @NotNull
  private Integer gender;
  @NotNull
  @Email
  private String email;
  @NotNull
  private String phoneNumber;
}
