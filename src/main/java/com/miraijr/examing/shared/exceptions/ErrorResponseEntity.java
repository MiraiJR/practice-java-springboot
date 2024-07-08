package com.miraijr.examing.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseEntity {
  private String errorCode;
  private String message;
  private String cause;
  private StackTraceElement[] backTrace;
}
