package com.miraijr.examing.core.adapter.mapping;

public interface IMappingDomainEntityAndJpaEntity<DomainEntity, JpaEntity> {
  public JpaEntity convertFromDomainEntityToJpaEntity(DomainEntity domainEntity);

  public DomainEntity convertFromJpaEntityToDomainEntity(JpaEntity jpaEntity);
}
