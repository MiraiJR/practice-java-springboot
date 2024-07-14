package com.miraijr.examing.modules.user.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.application.port.out.UserEventToKafkaPort;
import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserProducerAdapter implements UserEventToKafkaPort {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";
  private final static String COMPLETE_CREATE_USER_TOPIC = "complete-create-user";

  @Override
  public void reverseAccount(ReverseAccountEvent reverseAccountEvent) {
    this.kafkaTemplate.send(REVERSE_ACCOUNT_TOPIC, reverseAccountEvent);
  }

  @Override
  public void completeCreateUser(CompleteCreateUserEvent completeCreateUserEvent) {
    this.kafkaTemplate.send(COMPLETE_CREATE_USER_TOPIC, completeCreateUserEvent);
  }
}
