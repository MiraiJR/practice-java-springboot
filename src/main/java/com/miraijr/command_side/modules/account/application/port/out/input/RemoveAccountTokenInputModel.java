package com.miraijr.command_side.modules.account.application.port.out.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RemoveAccountTokenInputModel {
  private Long tokenId;
}
