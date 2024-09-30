package com.miraijr.command_side.modules.user.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class ExistedUserWithIdException extends ApplicationException {
  public ExistedUserWithIdException() {
    super("USER-ERROR-0001", "Existed user with id", HttpStatus.BAD_REQUEST);
  }
}
