package com.miraijr.examing.modules.user.adapter.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.infrastruction.config.KafkaConfiguration;
import com.miraijr.examing.modules.user.adapter.out.persistence.UserRedisRepository;
import com.miraijr.examing.modules.user.application.port.in.CreateUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.CreateUserInputModel;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserKafkaConsumer {
    private final static String CREATE_USER_TOPIC = "create-user";
    private final static String CACHE_USER_TOPIC = "cache-user";
    private final ObjectMapper objectMapper;
    private final CreateUserUseCase createUserUseCase;
    private final UserRedisRepository userRedisRepository;

    @KafkaListener(topics = { CREATE_USER_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
    @KafkaHandler(isDefault = true)
    public void createUser(ConsumerRecord<String, Object> record) {
        CreateUserInputModel inputData = this.objectMapper.convertValue(record.value(),
                CreateUserInputModel.class);
        this.createUserUseCase.execute(inputData);
    }

    @KafkaListener(topics = { CACHE_USER_TOPIC }, groupId = KafkaConfiguration.GROUP_ID)
    @KafkaHandler(isDefault = true)
    public void cacheUser(ConsumerRecord<String, Object> record) {
        User inputData = this.objectMapper.convertValue(record.value(),
                User.class);
        this.userRedisRepository.save(inputData);
    }
}
