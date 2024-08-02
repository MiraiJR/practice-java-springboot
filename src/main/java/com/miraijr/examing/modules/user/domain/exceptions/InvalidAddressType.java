package com.miraijr.examing.modules.user.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidAddressType extends DomainException {
  public InvalidAddressType() {
    super("DOMAIN-ADDRESS-ERROR-0001", "Invalid address type");
  }
}
