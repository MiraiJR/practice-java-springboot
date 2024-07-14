package com.miraijr.examing.modules.account.adapter.in;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.examing.modules.account.application.port.in.ReverseAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.UpdateAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.event.CompleteCreateUserEvent;
import com.miraijr.examing.modules.account.application.port.in.event.ReverseAccountEvent;
import com.miraijr.examing.modules.account.application.port.in.input.ChangeAccountStatusInputModel;
import com.miraijr.examing.modules.account.common.types.enums.AccountStatus;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountConsumerAdapter {
  private final static String REVERSE_ACCOUNT_TOPIC = "reverse-account";
  private final static String COMPLETE_CREATE_USER_TOPIC = "complete-create-user";
  private final ObjectMapper objectMapper;
  private final ReverseAccountUseCase reverseAccountUseCase;
  private final UpdateAccountUseCase updateAccountUseCase;

  @KafkaListener(topics = { REVERSE_ACCOUNT_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void reverseAccount(ConsumerRecord<String, Object> record) {
    ReverseAccountEvent eventData = this.objectMapper.convertValue(record.value(),
        ReverseAccountEvent.class);
    this.reverseAccountUseCase.execute(eventData);
  }

  @KafkaListener(topics = { COMPLETE_CREATE_USER_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
  @KafkaHandler(isDefault = true)
  public void completeCreateUser(ConsumerRecord<String, Object> record) {
    CompleteCreateUserEvent eventData = this.objectMapper.convertValue(record.value(),
        CompleteCreateUserEvent.class);
    this.updateAccountUseCase
        .changeStatusAccount(new ChangeAccountStatusInputModel(eventData.getAccountId(), AccountStatus.ACTIVE));
  }
}
