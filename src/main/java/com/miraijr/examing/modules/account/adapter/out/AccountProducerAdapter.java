package com.miraijr.examing.modules.account.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.account.application.port.out.AccountEventToKafkaPort;
import com.miraijr.examing.modules.account.application.port.out.input.CreateUserInputModel;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountProducerAdapter implements AccountEventToKafkaPort {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final static String CREATE_USER_TOPIC = "create-user";

    @Override
    public void sendCreateUserFromAccountTopic(CreateUserInputModel createUserInputModel) {
        this.kafkaTemplate.send(CREATE_USER_TOPIC, createUserInputModel);
    }
}
