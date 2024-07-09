package com.miraijr.examing.modules.account.application.port.in;

import com.miraijr.examing.modules.account.application.port.in.input.LoginAccountInputModel;
import com.miraijr.examing.modules.account.application.port.in.output.LoginAccountOutputModel;

public interface LoginAccountUseCase {
  public LoginAccountOutputModel execute(LoginAccountInputModel loginAccountInputModel);
}
