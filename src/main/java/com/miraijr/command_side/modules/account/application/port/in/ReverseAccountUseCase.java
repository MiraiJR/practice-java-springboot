package com.miraijr.command_side.modules.account.application.port.in;

import com.miraijr.command_side.modules.account.application.port.in.event.ReverseAccountEvent;

public interface ReverseAccountUseCase {
  public void execute(ReverseAccountEvent reverseAccountEvent);
}
