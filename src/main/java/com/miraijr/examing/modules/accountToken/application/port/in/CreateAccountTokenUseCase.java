package com.miraijr.examing.modules.accountToken.application.port.in;

import com.miraijr.examing.modules.accountToken.application.port.in.input.CreateAccountTokenInputModel;

public interface CreateAccountTokenUseCase {
  public void execute(CreateAccountTokenInputModel createAccountTokenInputModel);
}
