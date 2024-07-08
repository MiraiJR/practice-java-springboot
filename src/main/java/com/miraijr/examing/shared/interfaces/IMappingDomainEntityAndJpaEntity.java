package com.miraijr.examing.shared.interfaces;

public interface IMappingDomainEntityAndJpaEntity<DomainEntity, JpaEntity> {
  public JpaEntity convertFromDomainEntityToJpaEntity(DomainEntity domainEntity);

  public DomainEntity convertFromJpaEntityToDomainEntity(JpaEntity jpaEntity);
}
