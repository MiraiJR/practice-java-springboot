package com.miraijr.examing.modules.account.application.port.in;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterAccountInputModel {
  @NotNull
  @Length(min = 4, max = 50)
  private final String username;
  @NotNull
  @Length(min = 8, max = 50)
  private final String password;

  public RegisterAccountInputModel(
      String username,
      String password) {
    this.password = password;
    this.username = username;
  }
}
