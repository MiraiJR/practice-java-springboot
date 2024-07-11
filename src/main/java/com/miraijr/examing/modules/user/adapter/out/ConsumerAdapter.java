package com.miraijr.examing.modules.user.adapter.out;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@KafkaListener(topics = { ConsumerAdapter.CREATE_USER_FROM_ACCOUNT })
public class ConsumerAdapter {
    private final static String CREATE_USER_FROM_ACCOUNT = "create-user-from-account";
    private final ObjectMapper objectMapper;

    public void createUserFromAccount(Object data) {

    }
}
