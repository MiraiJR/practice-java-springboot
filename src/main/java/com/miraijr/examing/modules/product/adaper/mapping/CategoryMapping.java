package com.miraijr.examing.modules.product.adaper.mapping;

import org.springframework.stereotype.Component;
import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndRedisEntity;
import com.miraijr.examing.modules.product.adaper.out.persistence.jpa.CategoryEntityJpa;
import com.miraijr.examing.modules.product.adaper.out.persistence.redis.CategoryEntityRedis;
import com.miraijr.examing.modules.product.domain.Category;
import com.miraijr.examing.modules.product.domain.Category.CategoryBuilder;

@Component
public class CategoryMapping implements IMappingDomainEntityAndJpaEntity<Category, CategoryEntityJpa>,
    IMappingDomainEntityAndRedisEntity<Category, CategoryEntityRedis> {
  @Override
  public CategoryEntityJpa convertFromDomainEntityToJpaEntity(Category domainEntity) {
    var builder = CategoryEntityJpa.builder();
    builder.name(domainEntity.getName());
    builder.id(domainEntity.getId());
    builder.slug(domainEntity.getSlug());

    if (domainEntity.getParent() != null) {
      builder.parent(this.convertFromDomainEntityToJpaEntity(domainEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public Category convertFromJpaEntityToDomainEntity(CategoryEntityJpa jpaEntity) {
    var builder = Category.builder();
    builder.name(jpaEntity.getName());
    builder.id(jpaEntity.getId());
    builder.slug(jpaEntity.getSlug());

    if (jpaEntity.getParent() != null) {
      builder.parent(this.convertFromJpaEntityToDomainEntity(jpaEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public CategoryEntityRedis convertFromDomainEntityToRedisEntity(Category domainEntity) {
    var builder = CategoryEntityRedis.builder();
    builder.name(domainEntity.getName());
    builder.id(domainEntity.getId());
    builder.slug(domainEntity.getSlug());

    if (domainEntity.getParent() != null) {
      builder.parent(this.convertFromDomainEntityToRedisEntity(domainEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public Category convertFromRedisEntityToDomainEntity(CategoryEntityRedis redisEntity) {
    CategoryBuilder builder = Category.builder();
    builder.name(redisEntity.getName());
    builder.id(redisEntity.getId());
    builder.slug(redisEntity.getSlug());

    if (redisEntity.getParent() != null) {
      builder.parent(this.convertFromRedisEntityToDomainEntity(redisEntity.getParent()));
    }

    return builder.build();
  }
}
