package com.miraijr.command_side.core.domain.acount.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidPassword extends DomainException {
  public InvalidPassword() {
    super("DOMAIN-ACCOUNT-ERROR-0001", "Password has one uppercase letter, one numeric at least!");
  }
}
