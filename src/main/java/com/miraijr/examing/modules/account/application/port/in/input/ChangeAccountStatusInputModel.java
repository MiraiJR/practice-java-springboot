package com.miraijr.examing.modules.account.application.port.in.input;

import com.miraijr.examing.modules.account.common.types.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeAccountStatusInputModel {
  private Long accountId;
  private AccountStatus accountStatus;
}
