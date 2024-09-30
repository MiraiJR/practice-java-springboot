package com.miraijr.command_side.modules.user.application.port.in;

import com.miraijr.command_side.modules.user.application.port.in.input.CreateUserInputModel;

public interface CreateUserUseCase {
  public void execute(CreateUserInputModel createUserInputModel);
}
