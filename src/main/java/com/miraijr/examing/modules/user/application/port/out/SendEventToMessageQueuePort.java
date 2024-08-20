package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;
import com.miraijr.examing.modules.user.domain.User;

public interface SendEventToMessageQueuePort {
  void reverseAccount(ReverseAccountEvent eventModel);

  void completeCreateUser(CompleteCreateUserEvent eventModel);

  void cacheUser(User user);
}
