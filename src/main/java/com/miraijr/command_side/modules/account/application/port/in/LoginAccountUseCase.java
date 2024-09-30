package com.miraijr.command_side.modules.account.application.port.in;

import com.miraijr.command_side.modules.account.application.port.in.input.LoginAccountInputModel;
import com.miraijr.command_side.modules.account.application.port.in.output.LoginAccountOutputModel;

public interface LoginAccountUseCase {
  public LoginAccountOutputModel execute(LoginAccountInputModel loginAccountInputModel);
}
