package com.miraijr.examing.modules.user.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.examing.core.application.ApplicationException;

public class ReachTheMaximumAddressesPerUser extends ApplicationException {
  public ReachTheMaximumAddressesPerUser() {
    super("ERROR-ADDRESS-0001", "Current user reached the maximum number of addresses per user!",
        HttpStatus.BAD_REQUEST);
  }
}
