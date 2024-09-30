package com.miraijr.command_side.core.infrastruction.security.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class ExpiredTokenException extends ApplicationException {

  public ExpiredTokenException() {
    super("AUTH-ERROR-0002", "Expired token", HttpStatus.UNAUTHORIZED);
  }
}
