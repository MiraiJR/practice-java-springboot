package com.miraijr.command_side.modules.product.adaper.out.persistence.redis;

import org.springframework.data.repository.CrudRepository;

public interface ProductRedisRepository extends CrudRepository<ProductEntityRedis, Long> {

}
