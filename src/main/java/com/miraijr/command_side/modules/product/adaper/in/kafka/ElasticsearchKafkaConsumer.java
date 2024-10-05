package com.miraijr.command_side.modules.product.adaper.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.command_side.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch.CategoryElasticsearchAdapter;
import com.miraijr.command_side.modules.product.adaper.out.persistence.elasticsearch.ProductElasticsearchAdapter;
import com.miraijr.command_side.modules.product.common.resources.ChannelName;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ElasticsearchKafkaConsumer {
  private final ProductElasticsearchAdapter productElasticsearchAdapter;
  private final CategoryElasticsearchAdapter categoryElasticsearchAdapter;
  private final ObjectMapper objectMapper;

  @KafkaListener(topics = { ChannelName.ELASTICSEARCH_PRODUCT }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void insertProduct(ConsumerRecord<String, Object> record) {
    Product product = this.objectMapper.convertValue(record.value(),
        Product.class);
    this.productElasticsearchAdapter.insertProduct(product);
  }

  @KafkaListener(topics = { ChannelName.ELASTICSEARCH_CATEGORY }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void insertCategory(ConsumerRecord<String, Object> record) {
    Category category = this.objectMapper.convertValue(record.value(),
        Category.class);
    this.categoryElasticsearchAdapter.insertCategory(category);
  }
}
