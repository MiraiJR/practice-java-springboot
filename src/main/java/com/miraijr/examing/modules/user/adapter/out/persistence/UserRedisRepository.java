package com.miraijr.examing.modules.user.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.persistence.RedisRepository;
import com.miraijr.examing.modules.user.domain.User;

@Component
public class UserRedisRepository extends RedisRepository<User> {
  private final String PREFIX_KEY = "users:";

  public UserRedisRepository(RedisTemplate<String, Object> redisTemplate) {
    super(redisTemplate);
  }

  @Override
  public void save(User entity) {
    this.redisTemplate.opsForValue().set((PREFIX_KEY + entity.getId().toString()), entity);
  }

  @Override
  public Optional<User> findById(Long id) {
    User user = (User) this.redisTemplate.opsForValue()
        .get(PREFIX_KEY + id.toString());

    return user != null ? Optional.of(user) : Optional.empty();
  }
}
