package com.miraijr.examing.modules.user.application.port.in;

import com.miraijr.examing.modules.user.application.port.in.input.UpdateUserInputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UpdateUserOutputModel;

public interface UpdateUserUseCase {
  UpdateUserOutputModel updateUser(Long userId, UpdateUserInputModel inputModel);
}
