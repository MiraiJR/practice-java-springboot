package com.miraijr.examing.modules.accountToken.application.port.in.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAccountTokenInputModel {
  private Long tokenId;
}
