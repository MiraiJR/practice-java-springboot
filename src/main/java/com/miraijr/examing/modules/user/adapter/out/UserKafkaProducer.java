package com.miraijr.examing.modules.user.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.miraijr.examing.modules.user.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserKafkaProducer implements SendEventToMessageQueuePort {
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";
  private final static String COMPLETE_CREATE_USER_TOPIC = "complete-create-user";
  private final static String CACHE_USER_TOPIC = "cache-user";

  @Override
  public void reverseAccount(ReverseAccountEvent eventModel) {
    this.kafkaTemplate.send(REVERSE_ACCOUNT_TOPIC, eventModel);
  }

  @Override
  public void completeCreateUser(CompleteCreateUserEvent eventModel) {
    this.kafkaTemplate.send(COMPLETE_CREATE_USER_TOPIC, eventModel);
  }

  @Override
  public void cacheUser(User user) {
    this.kafkaTemplate.send(CACHE_USER_TOPIC, user);
  }
}
