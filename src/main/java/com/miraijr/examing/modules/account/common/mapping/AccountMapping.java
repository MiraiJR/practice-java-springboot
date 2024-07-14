package com.miraijr.examing.modules.account.common.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.adapter.out.persistence.AccountEntityJpa;
import com.miraijr.examing.modules.account.domain.Account;
import com.miraijr.examing.modules.account.domain.Password;
import com.miraijr.examing.modules.account.domain.Status;
import com.miraijr.examing.shared.interfaces.IMappingDomainEntityAndJpaEntity;

@Component
public class AccountMapping implements IMappingDomainEntityAndJpaEntity<Account, AccountEntityJpa> {

  @Override
  public AccountEntityJpa convertFromDomainEntityToJpaEntity(Account domainEntity) {
    return AccountEntityJpa.builder()
        .id(domainEntity.getId())
        .createdAt(domainEntity.getCreatedAt())
        .username(domainEntity.getUsername())
        .password(domainEntity.getPassword().getValue())
        .status(domainEntity.getStatus().getValue())
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
        .password(new Password(jpaEntity.getPassword(), true))
        .accessToken(jpaEntity.getAccessToken())
        .refreshToken(jpaEntity.getRefreshToken())
        .latestLogin(jpaEntity.getLatestLogin())
        .status(new Status(jpaEntity.getStatus()))
        .build();
  }
}
