package com.miraijr.command_side.modules.user.application.port.in.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserAddressInputModel {
  @NotNull
  @NotEmpty
  private String province;
  @NotNull
  @NotEmpty
  private String district;
  @NotNull
  @NotEmpty
  private String ward;
  @NotNull
  @NotEmpty
  private String homeAddress;
  @NotNull
  private Integer type;
}
