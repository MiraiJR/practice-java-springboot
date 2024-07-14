package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;

public interface UserEventToKafkaPort {
  void reverseAccount(ReverseAccountEvent reverseAccountEvent);

  void completeCreateUser(CompleteCreateUserEvent completeCreateUserEvent);
}
