package com.miraijr.command_side.modules.product.adaper.out.persistence.redis;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
  private Float price;
  private Long stock;
  private String slug;
  private Date createdAt;
  private Date updatedAt;
  private Long categoryId;
}
