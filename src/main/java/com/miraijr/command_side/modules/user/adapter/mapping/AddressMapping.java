package com.miraijr.command_side.modules.user.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.AddressEntityJpa;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.UserEntityJpa;
import com.miraijr.command_side.modules.user.adapter.out.persistence.redis.AddressEntityRedis;
import com.miraijr.command_side.modules.user.domain.Address;
import com.miraijr.command_side.modules.user.domain.AddressType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AddressMapping implements IMappingDomainEntityAndJpaEntity<Address, AddressEntityJpa> {
  @Override
  public AddressEntityJpa convertFromDomainEntityToJpaEntity(Address domainEntity) {
    return AddressEntityJpa.builder()
        .id(domainEntity.getId())
        .province(domainEntity.getProvince())
        .district(domainEntity.getDistrict())
        .homeAddress(domainEntity.getHomeAddress())
        .ward(domainEntity.getWard())
        .type(domainEntity.getType().getValue())
        .user(UserEntityJpa.builder().id(domainEntity.getUserId()).build())
        .build();
  }

  @Override
  public Address convertFromJpaEntityToDomainEntity(AddressEntityJpa jpaEntity) {
    return Address.builder()
        .id(jpaEntity.getId())
        .district(jpaEntity.getDistrict())
        .ward(jpaEntity.getWard())
        .province(jpaEntity.getProvince())
        .type(new AddressType(jpaEntity.getType()))
        .homeAddress(jpaEntity.getHomeAddress())
        .build();
  }

  public Address convertFromRedisEntityToDomainEntity(AddressEntityRedis redisEntity) {
    return Address.builder()
        .id(redisEntity.getId())
        .district(redisEntity.getDistrict())
        .ward(redisEntity.getWard())
        .province(redisEntity.getProvince())
        .type(new AddressType(redisEntity.getType()))
        .homeAddress(redisEntity.getHomeAddress())
        .build();
  }

  public AddressEntityRedis convertFromDomainEntityToRedisEntity(Address domainEntity) {
    return AddressEntityRedis.builder()
        .id(domainEntity.getId())
        .province(domainEntity.getProvince())
        .district(domainEntity.getDistrict())
        .homeAddress(domainEntity.getHomeAddress())
        .ward(domainEntity.getWard())
        .type(domainEntity.getType().getValue())
        .build();
  }
}
