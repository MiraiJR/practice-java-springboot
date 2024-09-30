package com.miraijr.command_side.core.adapter.persistence;

import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public abstract class RedisRepository<Entity> {
  protected final RedisTemplate<String, Object> redisTemplate;

  public abstract void save(Entity entity);

  public abstract Optional<Entity> findById(Long id);
}
