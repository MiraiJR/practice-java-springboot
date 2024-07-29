package com.miraijr.examing.modules.account.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.modules.account.adapter.out.persistence.AccountTokenEntityJpa;
import com.miraijr.examing.modules.account.domain.AccountToken;
import com.miraijr.examing.modules.account.domain.Device;
import com.miraijr.examing.shared.types.enums.DeviceType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountTokenMapping implements IMappingDomainEntityAndJpaEntity<AccountToken, AccountTokenEntityJpa> {
  private final AccountMapping accountMapping;

  @Override
  public AccountTokenEntityJpa convertFromDomainEntityToJpaEntity(AccountToken domainEntity) {
    return AccountTokenEntityJpa.builder()
        .id(domainEntity.getId())
        .accessToken(domainEntity.getAccessToken())
        .refreshToken(domainEntity.getRefreshToken())
        .device(DeviceType.valueOf(domainEntity.getDevice().getValue()))
        .account(this.accountMapping.convertFromDomainEntityToJpaEntity(domainEntity.getAccount()))
        .build();
  }

  @Override
  public AccountToken convertFromJpaEntityToDomainEntity(AccountTokenEntityJpa jpaEntity) {
    return AccountToken.builder()
        .id(jpaEntity.getId())
        .accessToken(jpaEntity.getAccessToken())
        .refreshToken(jpaEntity.getRefreshToken())
        .device(new Device(jpaEntity.getDevice().name()))
        .account(this.accountMapping.convertFromJpaEntityToDomainEntity(jpaEntity.getAccount()))
        .build();
  }

}
