package com.miraijr.command_side.modules.product.adaper.out.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.product.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.command_side.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductKafkaProducer implements SendEventToMessageQueuePort {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final static String ELASTICSEARCH_PRODUCT = "elasticsearch-product";
  private final static String CACHE_PRODUCT = "cache-product";
  private final static String[] TOPICS_FOR_EXTERNAL_SERVICE = { ELASTICSEARCH_PRODUCT, CACHE_PRODUCT };

  @Override
  public void sendProductToExternalService(Product product) {
    for (String topic : TOPICS_FOR_EXTERNAL_SERVICE) {
      this.kafkaTemplate.send(topic, product);
    }
  }
}
