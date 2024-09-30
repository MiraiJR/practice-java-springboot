package com.miraijr.command_side.core.domain.acount.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidStatus extends DomainException {

  public InvalidStatus() {
    super("DOMAIN-ACCOUNT-ERROR-0001", "Invalid status");
  }
}
