package com.miraijr.command_side.modules.account.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.account.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.command_side.modules.account.application.port.out.input.CreateAccountTokenInputModel;
import com.miraijr.command_side.modules.account.application.port.out.input.CreateUserInputModel;
import com.miraijr.command_side.modules.account.application.port.out.input.RemoveAccountTokenInputModel;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountKafkaProducer implements SendEventToMessageQueuePort {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final static String CREATE_USER_TOPIC = "create-user";
    private final static String CREATE_TOKEN_TOPIC = "create-token";
    private final static String REMOVE_TOKEN_TOPIC = "remove-token";

    @Override
    public void sendCreateUserFromAccountTopic(CreateUserInputModel inputModel) {
        this.kafkaTemplate.send(CREATE_USER_TOPIC, inputModel);
    }

    @Override
    public void sendCreateTokenTopic(CreateAccountTokenInputModel inputModel) {
        this.kafkaTemplate.send(CREATE_TOKEN_TOPIC, inputModel);
    }

    @Override
    public void sendRemoveTokenTopic(RemoveAccountTokenInputModel inputModel) {
        this.kafkaTemplate.send(REMOVE_TOKEN_TOPIC, inputModel);
    }
}
