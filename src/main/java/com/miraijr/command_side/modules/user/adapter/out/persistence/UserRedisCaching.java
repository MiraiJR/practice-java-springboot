package com.miraijr.command_side.modules.user.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.user.adapter.mapping.UserMapping;
import com.miraijr.command_side.modules.user.adapter.out.persistence.redis.UserEntityRedis;
import com.miraijr.command_side.modules.user.adapter.out.persistence.redis.UserRepositoryRedis;
import com.miraijr.command_side.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserRedisCaching {
  private final UserMapping userMapping;
  private final UserRepositoryRedis userRepositoryRedis;

  public void cache(User user) {
    UserEntityRedis userEntity = this.userMapping.convertFromDomainEntityToRedisEntity(user);
    this.userRepositoryRedis.save(userEntity);
  }
}
