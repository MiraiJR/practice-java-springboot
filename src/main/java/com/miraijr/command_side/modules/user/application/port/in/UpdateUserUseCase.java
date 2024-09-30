package com.miraijr.command_side.modules.user.application.port.in;

import com.miraijr.command_side.modules.user.application.port.in.input.UpdateUserInputModel;
import com.miraijr.command_side.modules.user.application.port.in.output.UpdateUserOutputModel;

public interface UpdateUserUseCase {
  UpdateUserOutputModel updateUser(Long userId, UpdateUserInputModel inputModel);
}
