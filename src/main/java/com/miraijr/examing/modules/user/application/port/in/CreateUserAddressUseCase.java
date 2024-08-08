package com.miraijr.examing.modules.user.application.port.in;

import com.miraijr.examing.modules.user.application.port.in.input.CreateUserAddressInputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UserAddressOutputModel;

public interface CreateUserAddressUseCase {
  UserAddressOutputModel createAddress(Long userId, CreateUserAddressInputModel inputModel);
}
