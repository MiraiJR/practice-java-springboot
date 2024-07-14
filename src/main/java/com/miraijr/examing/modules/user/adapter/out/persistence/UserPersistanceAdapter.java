package com.miraijr.examing.modules.user.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.application.port.out.CreateUserPort;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.common.mapping.UserMapping;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserPersistanceAdapter implements CreateUserPort, LoadUserPort {
  private final UserRepository userRepository;
  private final UserMapping userMapping;

  @Override
  public Optional<User> loadUser(Long id) {
    Optional<UserEntityJpa> user = this.userRepository.findById(id);
    return user.isPresent() ? Optional.of(this.userMapping.convertFromJpaEntityToDomainEntity(user.get()))
        : Optional.empty();
  }

  @Override
  public Long createUser(User user) {
    UserEntityJpa userEntity = this.userMapping.convertFromDomainEntityToJpaEntity(user);
    UserEntityJpa savedUser = this.userRepository.save(userEntity);
    return savedUser.getId();
  }
}
