package com.miraijr.examing.modules.user.application.port.in;

import com.miraijr.examing.modules.user.application.port.in.output.FullInformationUserOutputModel;

public interface GetUserUseCase {
  public FullInformationUserOutputModel loggedInUser(Long userId);
}
