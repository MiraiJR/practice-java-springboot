package com.miraijr.examing.modules.product.adaper.out.persistence.redis;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntityRedis {
  @Id
  private Long id;
  private String name;
  private String description;
  private Long stock;
  private Float price;
  private String slug;
  private CategoryEntityRedis category;
}
