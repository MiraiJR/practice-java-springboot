package com.miraijr.command_side.modules.account.application.port.out;

import com.miraijr.command_side.modules.account.application.port.out.input.CreateAccountTokenInputModel;
import com.miraijr.command_side.modules.account.application.port.out.input.CreateUserInputModel;
import com.miraijr.command_side.modules.account.application.port.out.input.RemoveAccountTokenInputModel;

public interface SendEventToMessageQueuePort {
    public void sendCreateUserFromAccountTopic(CreateUserInputModel inputModel);

    public void sendCreateTokenTopic(CreateAccountTokenInputModel inputModel);

    public void sendRemoveTokenTopic(RemoveAccountTokenInputModel inputModel);
}
