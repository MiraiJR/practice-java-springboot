package com.miraijr.examing.modules.product.adaper.out.persistence.redis;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.product.adaper.mapping.ProductMapping;
import com.miraijr.examing.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductRedisCaching {
  private final ProductRedisRepository productRedisRepository;
  private final ProductMapping productMapping;

  public void cache(Product product) {
    ProductEntityRedis redisEntity = this.productMapping.convertFromDomainEntityToRedisEntity(product);
    this.productRedisRepository.save(redisEntity);
  }
}
