package com.miraijr.command_side.modules.user.domain.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidAddressType extends DomainException {
  public InvalidAddressType() {
    super("DOMAIN-ADDRESS-ERROR-0001", "Invalid address type");
  }
}
