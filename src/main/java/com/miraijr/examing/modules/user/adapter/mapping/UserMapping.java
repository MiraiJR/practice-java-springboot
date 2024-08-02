package com.miraijr.examing.modules.user.adapter.mapping;

import com.miraijr.examing.modules.user.domain.User.UserBuilder;

import lombok.AllArgsConstructor;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.modules.user.adapter.out.persistence.UserEntityJpa;
import com.miraijr.examing.modules.user.domain.Email;
import com.miraijr.examing.modules.user.domain.PhoneNumber;
import com.miraijr.examing.modules.user.domain.User;

@Component
@AllArgsConstructor
public class UserMapping implements IMappingDomainEntityAndJpaEntity<User, UserEntityJpa> {
  private final AddressMapping addressMapping;

  @Override
  public UserEntityJpa convertFromDomainEntityToJpaEntity(User domainEntity) {
    return UserEntityJpa.builder()
        .id(domainEntity.getId())
        .fullName(domainEntity.getFullName())
        .build();
  }

  @Override
  public User convertFromJpaEntityToDomainEntity(UserEntityJpa jpaEntity) {
    UserBuilder userBuilder = User.builder()
        .id(jpaEntity.getId())
        .fullName(jpaEntity.getFullName());

    if (jpaEntity.getPhoneNumber() != null) {
      userBuilder.phoneNumber(new PhoneNumber(jpaEntity.getPhoneNumber()));
    }

    if (jpaEntity.getEmail() != null) {
      userBuilder.email(new Email(jpaEntity.getEmail()));
    }

    if (jpaEntity.getAddresses() != null) {
      userBuilder.addresses(
          jpaEntity.getAddresses().stream()
              .map(addressMapping::convertFromJpaEntityToDomainEntity)
              .collect(Collectors.toList()));
    }

    return userBuilder.build();
  }
}
