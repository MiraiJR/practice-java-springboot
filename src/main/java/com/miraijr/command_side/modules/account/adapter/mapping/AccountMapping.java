package com.miraijr.command_side.modules.account.adapter.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.command_side.core.domain.acount.Account;
import com.miraijr.command_side.core.domain.acount.Password;
import com.miraijr.command_side.core.domain.acount.Status;
import com.miraijr.command_side.modules.account.adapter.out.persistence.AccountEntityJpa;

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
