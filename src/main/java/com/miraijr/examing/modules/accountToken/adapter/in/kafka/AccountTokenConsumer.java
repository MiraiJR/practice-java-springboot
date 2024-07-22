package com.miraijr.examing.modules.accountToken.adapter.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.examing.modules.accountToken.application.port.in.CreateAccountTokenUseCase;
import com.miraijr.examing.modules.accountToken.application.port.in.DeleteAccountTokenUseCase;
import com.miraijr.examing.modules.accountToken.application.port.in.input.CreateAccountTokenInputModel;
import com.miraijr.examing.modules.accountToken.application.port.in.input.DeleteAccountTokenInputModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountTokenConsumer {
  private final static String CREATE_TOKEN_TOPIC = "create-token";
  private final static String REMOVE_TOKEN_TOPIC = "remove-token";
  private final ObjectMapper objectMapper;
  private final CreateAccountTokenUseCase createAccountTokenUseCase;
  private final DeleteAccountTokenUseCase deleteAccountTokenUseCase;

  @KafkaListener(topics = { CREATE_TOKEN_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
  public void createAccountToken(ConsumerRecord<String, Object> record) {
    CreateAccountTokenInputModel eventData = this.objectMapper.convertValue(record.value(),
        CreateAccountTokenInputModel.class);
    this.createAccountTokenUseCase.execute(eventData);
  }

  @KafkaListener(topics = { REMOVE_TOKEN_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
  public void removeAccountToken(ConsumerRecord<String, Object> record) {
    DeleteAccountTokenInputModel eventData = this.objectMapper.convertValue(record.value(),
        DeleteAccountTokenInputModel.class);
    this.deleteAccountTokenUseCase.deleteTokenById(eventData.getTokenId());
  }
}
