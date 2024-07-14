package com.miraijr.examing.modules.account.application.port.in.event;

import com.miraijr.examing.modules.user.common.types.enums.EventStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReverseAccountEvent {
  private Long accountId;
  private EventStatus eventStatus;
}
