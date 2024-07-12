package com.miraijr.examing.modules.user.application.port.in;

import com.miraijr.examing.modules.user.application.port.in.input.CreateUserInputModel;

public interface CreateUserUseCase {
  public void execute(CreateUserInputModel createUserInputModel);
}
