package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.application.port.out.model.CacheUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.examing.modules.user.application.port.out.model.ReverseAccountEvent;

public interface SendEventToMessageQueuePort {
  void reverseAccount(ReverseAccountEvent eventModel);

  void completeCreateUser(CompleteCreateUserEvent eventModel);

  void cacheUser(CacheUserEvent eventModel);
}
