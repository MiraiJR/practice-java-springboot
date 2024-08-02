package com.miraijr.examing.modules.user.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.modules.user.adapter.out.persistence.AddressEntityJpa;
import com.miraijr.examing.modules.user.adapter.out.persistence.UserEntityJpa;
import com.miraijr.examing.modules.user.domain.Address;
import com.miraijr.examing.modules.user.domain.AddressType;
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
        .user(UserEntityJpa.builder().id(domainEntity.getId()).build())
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
}
