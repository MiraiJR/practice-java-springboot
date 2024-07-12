package com.miraijr.examing.modules.user.application.port.out;

import java.util.Optional;

import com.miraijr.examing.modules.user.domain.User;

public interface LoadUserPort {
  public Optional<User> loadUser(Long id);
}
