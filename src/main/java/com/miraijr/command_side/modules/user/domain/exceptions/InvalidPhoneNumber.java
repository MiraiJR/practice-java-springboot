package com.miraijr.command_side.modules.user.domain.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidPhoneNumber extends DomainException {
  public InvalidPhoneNumber() {
    super("DOMAIN-USER-ERROR-0002", "Invalid phone number");
  }
}
