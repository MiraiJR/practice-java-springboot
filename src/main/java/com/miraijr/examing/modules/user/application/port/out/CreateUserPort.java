package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.domain.User;

public interface CreateUserPort {
  public Long createUser(User user);
}
