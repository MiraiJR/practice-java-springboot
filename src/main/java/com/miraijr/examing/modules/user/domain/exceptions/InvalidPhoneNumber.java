package com.miraijr.examing.modules.user.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidPhoneNumber extends DomainException {
  public InvalidPhoneNumber() {
    super("DOMAIN-USER-ERROR-0002", "Invalid phone number");
  }
}
