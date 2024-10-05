package com.miraijr.command_side.modules.product.adaper.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.command_side.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.command_side.modules.product.adaper.out.persistence.redis.CategoryRedisCaching;
import com.miraijr.command_side.modules.product.adaper.out.persistence.redis.ProductRedisCaching;
import com.miraijr.command_side.modules.product.common.resources.ChannelName;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RedisKafkaConsumer {
  private final ProductRedisCaching productRedisCaching;
  private final CategoryRedisCaching categoryRedisCaching;
  private final ObjectMapper objectMapper;

  @KafkaListener(topics = { ChannelName.CACHE_PRODUCT }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void cacheProduct(ConsumerRecord<String, Object> record) {
    Product product = this.objectMapper.convertValue(record.value(),
        Product.class);
    this.productRedisCaching.cache(product);
  }

  @KafkaListener(topics = { ChannelName.CACHE_CATEGORY }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void cacheCategory(ConsumerRecord<String, Object> record) {
    Category category = this.objectMapper.convertValue(record.value(),
        Category.class);
    this.categoryRedisCaching.cache(category);
  }
}
