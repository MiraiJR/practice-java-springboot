package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;

public interface SendEventToMessageQueuePort {
  void reverseAccount(ReverseAccountEvent reverseAccountEvent);

  void completeCreateUser(CompleteCreateUserEvent completeCreateUserEvent);
}
