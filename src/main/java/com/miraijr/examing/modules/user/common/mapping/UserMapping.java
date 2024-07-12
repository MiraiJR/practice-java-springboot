package com.miraijr.examing.modules.user.common.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.adapter.out.persistence.UserEntityJpa;
import com.miraijr.examing.modules.user.domain.User;
import com.miraijr.examing.shared.interfaces.IMappingDomainEntityAndJpaEntity;

@Component
public class UserMapping implements IMappingDomainEntityAndJpaEntity<User, UserEntityJpa> {

  @Override
  public UserEntityJpa convertFromDomainEntityToJpaEntity(User domainEntity) {
    return UserEntityJpa.builder()
        .id(domainEntity.getId())
        .fullName(domainEntity.getFullName())
        .build();
  }

  @Override
  public User convertFromJpaEntityToDomainEntity(UserEntityJpa jpaEntity) {
    return User.builder()
        .id(jpaEntity.getId())
        .fullName(jpaEntity.getFullName())
        .build();
  }

}
