package com.miraijr.examing.shared.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseModel {
  private String errorCode;
  private String message;
  private String cause;
  private Date requestedAt;
  private StackTraceElement[] backTrace;
}
