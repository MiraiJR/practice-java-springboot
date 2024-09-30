package com.miraijr.command_side.modules.account.application.port.in.input;

import com.miraijr.command_side.modules.account.common.types.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeAccountStatusInputModel {
  private Long accountId;
  private AccountStatus accountStatus;
}
