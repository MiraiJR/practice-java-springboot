package com.miraijr.examing.modules.user.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidEmail extends DomainException {
  public InvalidEmail() {
    super("DOMAIN-USER-ERROR-0001", "Invalid email address");
  }
}
