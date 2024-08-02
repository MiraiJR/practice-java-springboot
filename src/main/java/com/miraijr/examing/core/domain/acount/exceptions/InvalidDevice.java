package com.miraijr.examing.core.domain.acount.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidDevice extends DomainException {
  public InvalidDevice() {
    super("DOMAIN-ACCOUNT-TOKEN-ERROR-0001", "Invalid device");
  }
}
