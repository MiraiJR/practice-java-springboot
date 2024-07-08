package com.miraijr.examing.account.common.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.account.adapter.out.persistence.AccountEntityJpa;
import com.miraijr.examing.account.domain.Account;
import com.miraijr.examing.shared.interfaces.IMappingDomainEntityAndJpaEntity;

@Component
public class AccountMapping implements IMappingDomainEntityAndJpaEntity<Account, AccountEntityJpa> {

  @Override
  public AccountEntityJpa convertFromDomainEntityToJpaEntity(Account domainEntity) {
    return AccountEntityJpa.builder()
        .id(domainEntity.getId())
        .createdAt(domainEntity.getCreatedAt())
        .username(domainEntity.getUsername())
        .password(domainEntity.getPassword())
        .accessToken(domainEntity.getAccessToken())
        .refreshToken(domainEntity.getRefreshToken())
        .latestLogin(domainEntity.getLatestLogin())
        .build();
  }

  @Override
  public Account convertFromJpaEntityToDomainEntity(AccountEntityJpa jpaEntity) {
    return Account.builder()
        .id(jpaEntity.getId())
        .createdAt(jpaEntity.getCreatedAt())
        .username(jpaEntity.getUsername())
        .password(jpaEntity.getPassword())
        .accessToken(jpaEntity.getAccessToken())
        .refreshToken(jpaEntity.getRefreshToken())
        .latestLogin(jpaEntity.getLatestLogin())
        .build();
  }
}
