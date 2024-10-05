package com.miraijr.command_side.modules.product.adaper.out.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.product.application.port.out.SendCategoryEventToMessageQueuePort;
import com.miraijr.command_side.modules.product.common.resources.ChannelName;
import com.miraijr.command_side.modules.product.domain.Category;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryKafkaProducer implements SendCategoryEventToMessageQueuePort {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final static String[] TOPICS_FOR_EXTERNAL_SERVICE = { ChannelName.ELASTICSEARCH_CATEGORY,
            ChannelName.CACHE_CATEGORY };

    @Override
    public void sendCategoryToExternalService(Category category) {
        for (String topic : TOPICS_FOR_EXTERNAL_SERVICE) {
            this.kafkaTemplate.send(topic, category);
        }
    }
}
