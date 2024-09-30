package com.miraijr.command_side.modules.user.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class UserNotFoundException extends ApplicationException {
  public UserNotFoundException() {
    super("USER-ERROR-0002", "User not found", HttpStatus.NOT_FOUND);
  }
}
