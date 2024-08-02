package com.miraijr.examing.core.domain.acount.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidStatus extends DomainException {

  public InvalidStatus() {
    super("DOMAIN-ACCOUNT-ERROR-0001", "Invalid status");
  }
}
