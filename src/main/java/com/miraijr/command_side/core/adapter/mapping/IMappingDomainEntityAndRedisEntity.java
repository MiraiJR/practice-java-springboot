package com.miraijr.command_side.core.adapter.mapping;

public interface IMappingDomainEntityAndRedisEntity<DomainEntity, RedisEntity> {
  RedisEntity convertFromDomainEntityToRedisEntity(DomainEntity domainEntity);

  DomainEntity convertFromRedisEntityToDomainEntity(RedisEntity redisEntity);
}
