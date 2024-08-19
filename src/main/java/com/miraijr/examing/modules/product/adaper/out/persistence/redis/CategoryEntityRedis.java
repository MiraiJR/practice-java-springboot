package com.miraijr.examing.modules.product.adaper.out.persistence.redis;

import org.springframework.data.redis.core.RedisHash;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("categories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntityRedis {
  @Id
  private Long id;
  private CategoryEntityRedis parent;
  private String name;
  private String slug;
}
