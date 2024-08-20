package com.miraijr.examing.modules.product.adaper.mapping;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.examing.core.adapter.mapping.IMappingDomainEntityAndRedisEntity;
import com.miraijr.examing.modules.product.adaper.out.persistence.elasticsearch.ProductEntityElasticsearch;
import com.miraijr.examing.modules.product.adaper.out.persistence.jpa.ProductEntityJpa;
import com.miraijr.examing.modules.product.adaper.out.persistence.redis.ProductEntityRedis;
import com.miraijr.examing.modules.product.domain.Price;
import com.miraijr.examing.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductMapping implements IMappingDomainEntityAndJpaEntity<Product, ProductEntityJpa>,
    IMappingDomainEntityAndRedisEntity<Product, ProductEntityRedis> {
  private final CategoryMapping categoryMapping;

  @Override
  public ProductEntityJpa convertFromDomainEntityToJpaEntity(Product domainEntity) {
    var builder = ProductEntityJpa.builder();
    builder.id(domainEntity.getId())
        .name(domainEntity.getName())
        .description(domainEntity.getDescription())
        .price(BigDecimal.valueOf(domainEntity.getPrice().getValue()))
        .stock(domainEntity.getStock())
        .slug(domainEntity.getSlug())
        .category(this.categoryMapping.convertFromDomainEntityToJpaEntity(domainEntity.getCategory()));

    return builder.build();
  }

  @Override
  public Product convertFromJpaEntityToDomainEntity(ProductEntityJpa jpaEntity) {
    var builder = Product.builder();
    builder.id(jpaEntity.getId())
        .name(jpaEntity.getName())
        .description(jpaEntity.getDescription())
        .price(new Price(jpaEntity.getPrice().floatValue()))
        .stock(jpaEntity.getStock())
        .slug(jpaEntity.getSlug())
        .category(this.categoryMapping.convertFromJpaEntityToDomainEntity(jpaEntity.getCategory()));

    return builder.build();
  }

  public ProductEntityElasticsearch convertFromDomainEntityToElasticsearchEntity(Product domainEntity) {
    var builder = ProductEntityElasticsearch.builder();
    builder.id(domainEntity.getId())
        .name(domainEntity.getName())
        .description(domainEntity.getDescription())
        .price(domainEntity.getPrice().getValue().floatValue())
        .categoryName(domainEntity.getCategory().getName());

    return builder.build();
  }

  @Override
  public ProductEntityRedis convertFromDomainEntityToRedisEntity(Product domainEntity) {
    var builder = ProductEntityRedis.builder();
    builder.id(domainEntity.getId())
        .name(domainEntity.getName())
        .description(domainEntity.getDescription())
        .price(domainEntity.getPrice().getValue())
        .stock(domainEntity.getStock())
        .slug(domainEntity.getSlug())
        .category(this.categoryMapping.convertFromDomainEntityToRedisEntity(domainEntity.getCategory()));

    return builder.build();
  }

  @Override
  public Product convertFromRedisEntityToDomainEntity(ProductEntityRedis redisEntity) {
    var builder = Product.builder();
    builder.id(redisEntity.getId())
        .name(redisEntity.getName())
        .description(redisEntity.getDescription())
        .price(new Price(redisEntity.getPrice().floatValue()))
        .stock(redisEntity.getStock())
        .slug(redisEntity.getSlug())
        .category(this.categoryMapping.convertFromRedisEntityToDomainEntity(redisEntity.getCategory()));

    return builder.build();
  }
}
