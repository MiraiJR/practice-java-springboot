package com.miraijr.command_side.modules.user.adapter.out.persistence;

import java.util.Optional;
import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.user.adapter.mapping.UserMapping;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.UserEntityJpa;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.UserRepository;
import com.miraijr.command_side.modules.user.adapter.out.persistence.redis.UserEntityRedis;
import com.miraijr.command_side.modules.user.adapter.out.persistence.redis.UserRepositoryRedis;
import com.miraijr.command_side.modules.user.application.port.out.CreateUserPort;
import com.miraijr.command_side.modules.user.application.port.out.LoadUserPort;
import com.miraijr.command_side.modules.user.application.port.out.UpdateUserPort;
import com.miraijr.command_side.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserPersistanceAdapter implements CreateUserPort, LoadUserPort, UpdateUserPort {
  private final UserRepository userRepository;
  private final UserMapping userMapping;
  private final UserRepositoryRedis userRepositoryRedis;

  @Override
  public Optional<User> loadUser(Long id) {
    Optional<UserEntityJpa> userJpa = this.userRepository.findById(id);

    return userJpa.isPresent() ? Optional.of(this.userMapping.convertFromJpaEntityToDomainEntity(userJpa.get()))
        : Optional.empty();
  }

  @Override
  public User createUser(User user) {
    UserEntityJpa userEntity = this.userMapping.convertFromDomainEntityToJpaEntity(user);
    UserEntityJpa savedUser = this.userRepository.save(userEntity);
    return this.userMapping.convertFromJpaEntityToDomainEntity(savedUser);
  }

  @Override
  public Optional<User> loadUserFromCache(Long id) {
    Optional<UserEntityRedis> userRedis = this.userRepositoryRedis.findById(id);

    return userRedis.isPresent() ? Optional.of(this.userMapping.convertFromRedisEntityToDomainEntity(userRedis.get()))
        : Optional.empty();
  }

  @Override
  public User updateUser(User user) {
    UserEntityJpa userEntity = this.userMapping.convertFromDomainEntityToJpaEntity(user);
    UserEntityJpa savedUser = this.userRepository.save(userEntity);
    return this.userMapping.convertFromJpaEntityToDomainEntity(savedUser);
  }
}
