package com.miraijr.examing.modules.account.application.port.in;

import com.miraijr.examing.modules.account.application.port.in.input.RegisterAccountInputModel;

public interface RegisterAccountUseCase {
  public String execute(RegisterAccountInputModel registerAccountInputModel);
}
