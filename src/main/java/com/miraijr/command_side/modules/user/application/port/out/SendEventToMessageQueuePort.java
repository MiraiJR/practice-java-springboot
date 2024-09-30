package com.miraijr.command_side.modules.user.application.port.out;

import com.miraijr.command_side.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.command_side.modules.user.application.port.out.model.ReverseAccountEvent;
import com.miraijr.command_side.modules.user.domain.User;

public interface SendEventToMessageQueuePort {
  void reverseAccount(ReverseAccountEvent eventModel);

  void completeCreateUser(CompleteCreateUserEvent eventModel);

  void cacheUser(User user);
}
