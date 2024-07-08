package com.miraijr.examing.modules.account.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidPassword extends DomainException {
  public InvalidPassword() {
    super("DOMAIN-ACCOUNT-ERROR-0001", "Password has one uppercase letter, one numeric at least!");
  }
}
