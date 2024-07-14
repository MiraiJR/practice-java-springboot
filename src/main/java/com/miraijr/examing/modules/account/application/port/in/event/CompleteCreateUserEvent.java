package com.miraijr.examing.modules.account.application.port.in.event;

import com.miraijr.examing.modules.account.common.types.enums.EventStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompleteCreateUserEvent {
  private Long accountId;
  private EventStatus eventStatus;
}
