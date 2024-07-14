package com.miraijr.examing.core.infrastruction.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfiguration {
  public final static String GROUP_ID = "exam-outline-pj";
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";
  private final static String CREATE_USER_TOPIC = "create-user";

  @Bean
  CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
    return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
  }

  @Bean
  NewTopic createUserTopic() {
    return new NewTopic(CREATE_USER_TOPIC, 1, (short) 1);
  }

  @Bean
  NewTopic reverseAccountTopic() {
    return new NewTopic(REVERSE_ACCOUNT_TOPIC, 1, (short) 1);
  }
}
