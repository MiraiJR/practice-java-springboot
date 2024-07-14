package com.miraijr.examing.modules.user.application.port.out.model;

import com.miraijr.examing.modules.user.common.types.enums.EventStatus;

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
