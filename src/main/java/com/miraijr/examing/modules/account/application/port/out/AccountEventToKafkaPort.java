package com.miraijr.examing.modules.account.application.port.out;

import com.miraijr.examing.modules.account.application.port.out.input.CreateAccountTokenInputModel;
import com.miraijr.examing.modules.account.application.port.out.input.CreateUserInputModel;
import com.miraijr.examing.modules.account.application.port.out.input.RemoveAccountTokenInputModel;

public interface AccountEventToKafkaPort {
    public void sendCreateUserFromAccountTopic(CreateUserInputModel inputModel);

    public void sendCreateTokenTopic(CreateAccountTokenInputModel inputModel);

    public void sendRemoveTokenTopic(RemoveAccountTokenInputModel inputModel);
}
