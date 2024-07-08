package com.miraijr.examing.modules.account.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.examing.core.application.ApplicationException;

public class UsernameExistedException extends ApplicationException {
  public UsernameExistedException() {
    super("REFISTER-ACCOUNT-ERROR-0001", "Username is used!", HttpStatus.BAD_REQUEST);
  }
}
