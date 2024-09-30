package com.miraijr.command_side.modules.user.application.port.out;

import java.util.Optional;

import com.miraijr.command_side.modules.user.domain.User;

public interface LoadUserPort {
  Optional<User> loadUser(Long id);

  Optional<User> loadUserFromCache(Long id);
}
