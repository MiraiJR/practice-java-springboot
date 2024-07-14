package com.miraijr.examing.modules.user.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.application.port.out.UserEventToKafkaPort;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserProducerAdapter implements UserEventToKafkaPort {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";

  @Override
  public void reverseAccount(ReverseAccountEvent reverseAccountEvent) {
    this.kafkaTemplate.send(REVERSE_ACCOUNT_TOPIC, reverseAccountEvent);
  }
}
