package com.miraijr.examing.modules.accountToken.application;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.modules.accountToken.application.port.in.DeleteAccountTokenUseCase;
import com.miraijr.examing.modules.accountToken.application.port.out.DeleteAccountTokenPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteAccountToken implements DeleteAccountTokenUseCase {
  private final DeleteAccountTokenPort deleteAccountTokenPort;

  @Override
  @Transactional("transactionManager")
  public void deleteTokenById(Long tokenId) {
    this.deleteAccountTokenPort.deleteById(tokenId);
  }
}
