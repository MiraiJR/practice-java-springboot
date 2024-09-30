package com.miraijr.command_side.core.infrastruction.security.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class InvalidTokenException extends ApplicationException {
  public InvalidTokenException() {
    super("AUTH-ERROR-0001", "Invalid token", HttpStatus.UNAUTHORIZED);
  }
}
