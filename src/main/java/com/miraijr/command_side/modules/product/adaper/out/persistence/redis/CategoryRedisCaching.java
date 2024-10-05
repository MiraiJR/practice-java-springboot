package com.miraijr.command_side.modules.product.adaper.out.persistence.redis;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.product.adaper.mapping.CategoryMapping;
import com.miraijr.command_side.modules.product.domain.Category;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryRedisCaching {
    private final CategoryRedisRepository categoryRedisRepository;
    private final CategoryMapping categoryMapping;

    public void cache(Category category) {
        CategoryEntityRedis redisEntity = this.categoryMapping.convertFromDomainEntityToRedisEntity(category);
        this.categoryRedisRepository.save(redisEntity);
    }
}
