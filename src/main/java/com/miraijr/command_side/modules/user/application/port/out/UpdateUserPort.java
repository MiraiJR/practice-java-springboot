package com.miraijr.command_side.modules.user.application.port.out;

import com.miraijr.command_side.modules.user.domain.User;

public interface UpdateUserPort {
  User updateUser(User user);
}
