package com.miraijr.examing.modules.account.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.examing.core.application.ApplicationException;

public class WrongInforLoginException extends ApplicationException {

  public WrongInforLoginException() {
    super("LOGIN-ACCOUNT-ERROR-0001", "UserName or password is not correct", HttpStatus.BAD_REQUEST);
  }
}
