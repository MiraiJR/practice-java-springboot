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
  private final static String CREATE_USER_FROM_ACCOUNT = "create-user-from-account";

  @Bean
  CommonErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
    return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
  }

  @Bean
  NewTopic createUserFromAccountTopic() {
    return new NewTopic(CREATE_USER_FROM_ACCOUNT, 1, (short) 1);
  }
}
