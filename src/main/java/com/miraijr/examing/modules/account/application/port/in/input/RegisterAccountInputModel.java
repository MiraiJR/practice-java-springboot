package com.miraijr.examing.modules.account.application.port.in.input;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterAccountInputModel {
  @NotNull
  @Length(min = 4, max = 50)
  private final String username;
  @NotNull
  @Length(min = 8, max = 50)
  private final String password;
  @NotNull
  @Length(min = 2)
  private final String fullName;
}
