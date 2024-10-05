package com.miraijr.command_side.modules.product.adaper.mapping;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndRedisEntity;
import com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch.CategoryEntityElasticsearch;
import com.miraijr.command_side.modules.product.adaper.out.persistence.jpa.CategoryEntityJpa;
import com.miraijr.command_side.modules.product.adaper.out.persistence.redis.CategoryEntityRedis;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Category.CategoryBuilder;

@Component
public class CategoryMapping implements IMappingDomainEntityAndJpaEntity<Category, CategoryEntityJpa>,
    IMappingDomainEntityAndRedisEntity<Category, CategoryEntityRedis> {
  @Override
  public CategoryEntityJpa convertFromDomainEntityToJpaEntity(Category domainEntity) {
    var builder = CategoryEntityJpa.builder();
    builder.name(domainEntity.getName())
        .id(domainEntity.getId())
        .slug(domainEntity.getSlug())
        .createdAt(domainEntity.getCreatedAt())
        .updatedAt(domainEntity.getUpdatedAt());

    if (domainEntity.getParent() != null) {
      builder.parent(this.convertFromDomainEntityToJpaEntity(domainEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public Category convertFromJpaEntityToDomainEntity(CategoryEntityJpa jpaEntity) {
    var builder = Category.builder();
    builder.id(jpaEntity.getId())
        .name(jpaEntity.getName())
        .slug(jpaEntity.getSlug())
        .createdAt(jpaEntity.getCreatedAt())
        .updatedAt(jpaEntity.getUpdatedAt());

    if (jpaEntity.getParent() != null) {
      builder.parent(this.convertFromJpaEntityToDomainEntity(jpaEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public CategoryEntityRedis convertFromDomainEntityToRedisEntity(Category domainEntity) {
    var builder = CategoryEntityRedis.builder();
    builder.name(domainEntity.getName())
        .id(domainEntity.getId())
        .slug(domainEntity.getSlug())
        .createdAt(domainEntity.getCreatedAt())
        .updatedAt(domainEntity.getUpdatedAt());

    if (domainEntity.getParent() != null) {
      builder.parent(this.convertFromDomainEntityToRedisEntity(domainEntity.getParent()));
    }

    return builder.build();
  }

  @Override
  public Category convertFromRedisEntityToDomainEntity(CategoryEntityRedis redisEntity) {
    CategoryBuilder builder = Category.builder();
    builder.name(redisEntity.getName())
        .id(redisEntity.getId())
        .slug(redisEntity.getSlug())
        .createdAt(redisEntity.getCreatedAt())
        .updatedAt(redisEntity.getUpdatedAt());

    if (redisEntity.getParent() != null) {
      builder.parent(this.convertFromRedisEntityToDomainEntity(redisEntity.getParent()));
    }

    return builder.build();
  }

  public CategoryEntityElasticsearch convertFromDomainEntityToElasticsearchEntity(Category domainEntity) {
    var builder = CategoryEntityElasticsearch.builder();

    builder.id(domainEntity.getId())
        .name(domainEntity.getName())
        .slug(domainEntity.getSlug())
        .createdAt(domainEntity.getCreatedAt())
        .updatedAt(domainEntity.getUpdatedAt());

    if (domainEntity.getParent() != null) {
      builder.parentId(domainEntity.getParent().getId());
    }

    return builder.build();
  }
}
