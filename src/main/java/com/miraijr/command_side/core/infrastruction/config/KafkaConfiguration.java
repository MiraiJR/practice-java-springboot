package com.miraijr.command_side.core.infrastruction.config;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);
  public final static String GROUP_ID = "exam-outline-pj";
  private final static List<String> TOPICS = List.of(
      "cache-user",
      "complete-create-user",
      "reverse-account",
      "create-user");

  @Bean
  DeadLetterPublishingRecoverer deadLetterPublishingRecoverer(KafkaTemplate<Object, Object> template) {
    return new DeadLetterPublishingRecoverer(template);
  }

  @Bean
  CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
    DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(template);

    DefaultErrorHandler errorHandler = new DefaultErrorHandler((record, exception) -> {
      logger.error("Deserialization failed for record with key: {} on topic-partition {}. Error: {}",
          record.key(), record.topic() + "-" + record.partition(), exception.getMessage());
      recoverer.accept(record, exception);
    }, new FixedBackOff(0L, 2L));

    return errorHandler;
  }

  @Bean
  List<NewTopic> generateTopics() {
    return TOPICS.stream()
        .map(topicName -> new NewTopic(topicName, 1, (short) 1))
        .collect(Collectors.toList());
  }
}
