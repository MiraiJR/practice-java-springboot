package com.miraijr.examing.modules.account.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.examing.core.application.ApplicationException;

public class AccountNotFoundException extends ApplicationException {

  public AccountNotFoundException() {
    super("ACCOUNT-ERROR-0001", "Account not found", HttpStatus.NOT_FOUND);
  }

}
