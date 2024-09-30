package com.miraijr.command_side.modules.account.application.port.in;

import com.miraijr.command_side.modules.account.application.port.in.input.RegisterAccountInputModel;

public interface RegisterAccountUseCase {
  public String execute(RegisterAccountInputModel registerAccountInputModel);
}
