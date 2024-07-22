package com.miraijr.examing.modules.account.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.modules.account.adapter.out.persistence.AccountEntityJpa;
import com.miraijr.examing.modules.account.domain.Account;
import com.miraijr.examing.modules.account.domain.Password;
import com.miraijr.examing.modules.account.domain.Status;

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
        .latestLogin(jpaEntity.getLatestLogin())
        .status(new Status(jpaEntity.getStatus()))
        .build();
  }
}
