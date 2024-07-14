package com.miraijr.examing.modules.account.application.port.in;

import com.miraijr.examing.modules.account.application.port.in.input.ReverseAccountEvent;

public interface ReverseAccountUseCase {
  public void execute(ReverseAccountEvent reverseAccountEvent);
}
