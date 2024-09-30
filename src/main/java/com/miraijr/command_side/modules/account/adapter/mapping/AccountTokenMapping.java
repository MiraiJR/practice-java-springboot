package com.miraijr.command_side.modules.account.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.command_side.core.domain.acount.AccountToken;
import com.miraijr.command_side.core.domain.acount.Device;
import com.miraijr.command_side.modules.account.adapter.out.persistence.AccountEntityJpa;
import com.miraijr.command_side.modules.account.adapter.out.persistence.AccountTokenEntityJpa;
import com.miraijr.command_side.shared.types.enums.DeviceType;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountTokenMapping implements IMappingDomainEntityAndJpaEntity<AccountToken, AccountTokenEntityJpa> {
  @Override
  public AccountTokenEntityJpa convertFromDomainEntityToJpaEntity(AccountToken domainEntity) {
    return AccountTokenEntityJpa.builder()
        .id(domainEntity.getId())
        .accessToken(domainEntity.getAccessToken())
        .refreshToken(domainEntity.getRefreshToken())
        .device(DeviceType.valueOf(domainEntity.getDevice().getValue()))
        .account(AccountEntityJpa.builder().id(domainEntity.getAccountId()).build())
        .build();
  }

  @Override
  public AccountToken convertFromJpaEntityToDomainEntity(AccountTokenEntityJpa jpaEntity) {
    return AccountToken.builder()
        .id(jpaEntity.getId())
        .accessToken(jpaEntity.getAccessToken())
        .refreshToken(jpaEntity.getRefreshToken())
        .device(new Device(jpaEntity.getDevice().name()))
        .accountId(jpaEntity.getAccount().getId())
        .build();
  }
}
