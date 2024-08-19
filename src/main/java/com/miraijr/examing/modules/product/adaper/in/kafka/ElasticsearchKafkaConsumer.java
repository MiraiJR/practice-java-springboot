package com.miraijr.examing.modules.product.adaper.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.examing.modules.product.adaper.out.persistence.elasticsearch.ProductElasticsearchAdapter;
import com.miraijr.examing.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ElasticsearchKafkaConsumer {
  private final static String ELASTICSEARCH_PRODUCT = "elasticsearch-product";
  private final ProductElasticsearchAdapter productElasticsearchAdapter;
  private final ObjectMapper objectMapper;

  @KafkaListener(topics = { ELASTICSEARCH_PRODUCT }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void insertProduct(ConsumerRecord<String, Object> record) {
    Product product = this.objectMapper.convertValue(record.value(),
        Product.class);
    this.productElasticsearchAdapter.insertProduct(product);
  }
}
