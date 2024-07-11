package com.miraijr.examing.modules.account.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.port.out.SendMessageToKafkaPort;
import com.miraijr.examing.modules.account.application.port.out.input.CreateUserInputModel;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProducerAdapter implements SendMessageToKafkaPort {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final static String CREATE_USER_FROM_ACCOUNT = "create-user-from-account";

    @Override
    public void sendCreateUserFromAccountTopic(CreateUserInputModel createUserInputModel) {
        this.kafkaTemplate.send(CREATE_USER_FROM_ACCOUNT, createUserInputModel);
    }
}
