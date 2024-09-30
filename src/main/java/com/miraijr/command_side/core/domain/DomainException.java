package com.miraijr.command_side.core.domain;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {
  private final String errorCode;

  public DomainException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
