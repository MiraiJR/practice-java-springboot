package com.miraijr.examing.modules.user.adapter.mapping;

import com.miraijr.examing.modules.user.domain.User.UserBuilder;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.modules.user.adapter.out.persistence.jpa.UserEntityJpa;
import com.miraijr.examing.modules.user.adapter.out.persistence.jpa.UserEntityJpa.UserEntityJpaBuilder;
import com.miraijr.examing.modules.user.adapter.out.persistence.redis.UserEntityRedis;
import com.miraijr.examing.modules.user.adapter.out.persistence.redis.UserEntityRedis.UserEntityRedisBuilder;
import com.miraijr.examing.modules.user.domain.Email;
import com.miraijr.examing.modules.user.domain.Gender;
import com.miraijr.examing.modules.user.domain.PhoneNumber;
import com.miraijr.examing.modules.user.domain.User;

@Component
@AllArgsConstructor
public class UserMapping implements IMappingDomainEntityAndJpaEntity<User, UserEntityJpa> {
  private final AddressMapping addressMapping;

  @Override
  public UserEntityJpa convertFromDomainEntityToJpaEntity(User domainEntity) {
    UserEntityJpaBuilder builder = UserEntityJpa.builder()
        .id(domainEntity.getId())
        .fullName(domainEntity.getFullName());

    if (domainEntity.getPhoneNumber() != null) {
      builder.phoneNumber(domainEntity.getPhoneNumber().getValue());
    }

    if (domainEntity.getEmail() != null) {
      builder.email(domainEntity.getEmail().getValue());
    }

    if (domainEntity.getGender() != null) {
      builder.gender(domainEntity.getGender().getValue());
    }

    return builder.build();
  }

  @Override
  public User convertFromJpaEntityToDomainEntity(UserEntityJpa jpaEntity) {
    UserBuilder builder = User.builder()
        .id(jpaEntity.getId())
        .fullName(jpaEntity.getFullName());

    if (jpaEntity.getPhoneNumber() != null) {
      builder.phoneNumber(new PhoneNumber(jpaEntity.getPhoneNumber()));
    }

    if (jpaEntity.getEmail() != null) {
      builder.email(new Email(jpaEntity.getEmail()));
    }

    if (jpaEntity.getGender() != null) {
      builder.gender(new Gender(jpaEntity.getGender()));
    }

    if (jpaEntity.getAddresses() != null) {
      builder.addresses(
          jpaEntity.getAddresses().stream()
              .map(addressMapping::convertFromJpaEntityToDomainEntity)
              .collect(Collectors.toList()));
    } else {
      builder.addresses(Collections.emptyList());
    }

    return builder.build();
  }

  public User convertFromRedisEntityToDomainEntity(UserEntityRedis redisEntity) {
    UserBuilder builder = User.builder()
        .id(redisEntity.getId())
        .fullName(redisEntity.getFullName());

    if (redisEntity.getPhoneNumber() != null) {
      builder.phoneNumber(new PhoneNumber(redisEntity.getPhoneNumber()));
    }

    if (redisEntity.getEmail() != null) {
      builder.email(new Email(redisEntity.getEmail()));
    }

    if (redisEntity.getGender() != null) {
      builder.gender(new Gender(redisEntity.getGender()));
    }

    if (redisEntity.getAddresses() != null) {
      builder.addresses(
          redisEntity.getAddresses().stream()
              .map(addressMapping::convertFromRedisEntityToDomainEntity)
              .collect(Collectors.toList()));
    } else {
      builder.addresses(Collections.emptyList());
    }

    return builder.build();
  }

  public UserEntityRedis convertFromDomainEntityToRedisEntity(User domainEntity) {
    UserEntityRedisBuilder builder = UserEntityRedis.builder()
        .id(domainEntity.getId())
        .fullName(domainEntity.getFullName());

    if (domainEntity.getPhoneNumber() != null) {
      builder.phoneNumber(domainEntity.getPhoneNumber().getValue());
    }

    if (domainEntity.getEmail() != null) {
      builder.email(domainEntity.getEmail().getValue());
    }

    if (domainEntity.getGender() != null) {
      builder.gender(domainEntity.getGender().getValue());
    }

    if (domainEntity.getAddresses() != null) {
      builder.addresses(domainEntity.getAddresses()
          .stream()
          .map(addressMapping::convertFromDomainEntityToRedisEntity)
          .collect(Collectors.toList()));
    } else {
      builder.addresses(Collections.emptyList());
    }

    return builder.build();
  }
}
