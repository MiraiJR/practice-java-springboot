package com.miraijr.command_side.modules.user.domain.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidEmail extends DomainException {
  public InvalidEmail() {
    super("DOMAIN-USER-ERROR-0001", "Invalid email address");
  }
}
