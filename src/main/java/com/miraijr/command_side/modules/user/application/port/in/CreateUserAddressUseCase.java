package com.miraijr.command_side.modules.user.application.port.in;

import com.miraijr.command_side.modules.user.application.port.in.input.CreateUserAddressInputModel;
import com.miraijr.command_side.modules.user.application.port.in.output.UserAddressOutputModel;

public interface CreateUserAddressUseCase {
  UserAddressOutputModel createAddress(Long userId, CreateUserAddressInputModel inputModel);
}
