package com.miraijr.command_side.modules.product.adaper.mapping;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndJpaEntity;
import com.miraijr.command_side.core.adapter.mapping.IMappingDomainEntityAndRedisEntity;
import com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch.ProductEntityElasticsearch;
import com.miraijr.command_side.modules.product.adaper.out.persistence.jpa.ProductEntityJpa;
import com.miraijr.command_side.modules.product.adaper.out.persistence.redis.ProductEntityRedis;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Price;
import com.miraijr.command_side.modules.product.domain.Product;

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
                .createdAt(domainEntity.getCreatedAt())
                .updatedAt(domainEntity.getUpdatedAt())
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
                .createdAt(jpaEntity.getCreatedAt())
                .updatedAt(jpaEntity.getUpdatedAt())
                .category(this.categoryMapping.convertFromJpaEntityToDomainEntity(jpaEntity.getCategory()));

        return builder.build();
    }

    public ProductEntityElasticsearch convertFromDomainEntityToElasticsearchEntity(Product domainEntity) {
        var builder = ProductEntityElasticsearch.builder();
        builder.id(domainEntity.getId())
                .name(domainEntity.getName())
                .description(domainEntity.getDescription())
                .price(domainEntity.getPrice().getValue())
                .slug(domainEntity.getSlug())
                .createdAt(domainEntity.getCreatedAt())
                .updatedAt(domainEntity.getUpdatedAt())
                .categoryId(domainEntity.getCategory().getId());

        return builder.build();
    }

    public Product convertFromElasticsearchEntityToDomainEntity(ProductEntityElasticsearch entity) {
        var builder = Product.builder();
        builder.id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(new Price(entity.getPrice().floatValue()))
                .slug(entity.getSlug())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .category(new Category(entity.getCategoryId()));

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
                .createdAt(domainEntity.getCreatedAt())
                .updatedAt(domainEntity.getUpdatedAt())
                .categoryId(domainEntity.getCategory().getId());

        return builder.build();
    }

    @Override
    public Product convertFromRedisEntityToDomainEntity(ProductEntityRedis redisEntity) {
        var builder = Product.builder();
        builder.id(redisEntity.getId())
                .name(redisEntity.getName())
                .description(redisEntity.getDescription())
                .price(new Price(redisEntity.getPrice()))
                .stock(redisEntity.getStock())
                .slug(redisEntity.getSlug())
                .createdAt(redisEntity.getCreatedAt())
                .updatedAt(redisEntity.getUpdatedAt())
                .category(new Category(redisEntity.getCategoryId()));

        return builder.build();
    }
}
