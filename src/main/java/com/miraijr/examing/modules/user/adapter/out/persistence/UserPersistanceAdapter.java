package com.miraijr.examing.modules.user.adapter.out.persistence;

import java.util.LinkedHashMap;
import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.modules.user.adapter.mapping.UserMapping;
import com.miraijr.examing.modules.user.application.port.out.CreateUserPort;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserPersistanceAdapter implements CreateUserPort, LoadUserPort {
  private final UserRepository userRepository;
  private final RedisTemplate<String, Object> redisTemplate;
  private final UserMapping userMapping;

  @Override
  public Optional<User> loadUser(Long id) {
    UserEntityJpa userInRedis = (UserEntityJpa) this.redisTemplate.opsForValue()
        .get(String.format("users:%d", id));

    if (userInRedis != null) {
      return Optional.of(this.userMapping.convertFromJpaEntityToDomainEntity(userInRedis));
    }

    Optional<UserEntityJpa> user = this.userRepository.findById(id);
    return user.isPresent() ? Optional.of(this.userMapping.convertFromJpaEntityToDomainEntity(user.get()))
        : Optional.empty();
  }

  @Override
  public Long createUser(User user) {
    UserEntityJpa userEntity = this.userMapping.convertFromDomainEntityToJpaEntity(user);
    UserEntityJpa savedUser = this.userRepository.save(userEntity);
    this.redisTemplate.opsForValue().set(String.format("users:%d",
        savedUser.getId()), savedUser);
    return savedUser.getId();
  }
}
