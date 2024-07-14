package com.miraijr.examing.modules.account.application.port.out;

import com.miraijr.examing.modules.account.application.port.out.input.CreateUserInputModel;

public interface AccountEventToKafkaPort {
    public void sendCreateUserFromAccountTopic(CreateUserInputModel createUserInputModel);
}
