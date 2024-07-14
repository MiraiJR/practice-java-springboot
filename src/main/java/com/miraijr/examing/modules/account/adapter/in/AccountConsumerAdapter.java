package com.miraijr.examing.modules.account.adapter.in;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.examing.modules.account.application.port.in.ReverseAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.ReverseAccountEvent;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountConsumerAdapter {
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";
  private final ObjectMapper objectMapper;
  private final ReverseAccountUseCase reverseAccountUseCase;

  @KafkaListener(topics = { REVERSE_ACCOUNT_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void reverseAccount(ConsumerRecord<String, Object> record) {
    ReverseAccountEvent eventData = this.objectMapper.convertValue(record.value(),
        ReverseAccountEvent.class);
    this.reverseAccountUseCase.execute(eventData);
  }
}
