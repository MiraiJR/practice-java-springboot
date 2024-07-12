package com.miraijr.examing.modules.user.adapter.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.modules.user.application.port.in.CreateUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.CreateUserInputModel;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConsumerAdapter {
    private final static String CREATE_USER_FROM_ACCOUNT = "create-user-from-account";
    private final ObjectMapper objectMapper;
    private final CreateUserUseCase createUserUseCase;

    @KafkaListener(topics = { CREATE_USER_FROM_ACCOUNT }, groupId = "group_id")
    @KafkaHandler(isDefault = true)
    public void createUserFromAccount(ConsumerRecord<String, Object> record) {
        try {
            CreateUserInputModel inputData = this.objectMapper.convertValue(record.value(),
                    CreateUserInputModel.class);
            this.createUserUseCase.execute(inputData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
