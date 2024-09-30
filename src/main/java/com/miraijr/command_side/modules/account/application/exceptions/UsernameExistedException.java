package com.miraijr.command_side.modules.account.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class UsernameExistedException extends ApplicationException {
  public UsernameExistedException() {
    super("REFISTER-ACCOUNT-ERROR-0001", "Username is used!", HttpStatus.BAD_REQUEST);
  }
}
