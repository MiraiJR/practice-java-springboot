package com.miraijr.examing.modules.user.adapter.out;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ConsumerAdapter {
    private final static String CREATE_USER_FROM_ACCOUNT = "create-user-from-account";
    // private final ObjectMapper objectMapper;

    @KafkaListener(topics = { ConsumerAdapter.CREATE_USER_FROM_ACCOUNT })
    public void createUserFromAccount(Object data) {
        System.out.println("Received: " + data);
    }
}
