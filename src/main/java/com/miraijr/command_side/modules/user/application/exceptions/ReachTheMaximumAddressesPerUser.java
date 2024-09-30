package com.miraijr.command_side.modules.user.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.command_side.core.application.ApplicationException;

public class ReachTheMaximumAddressesPerUser extends ApplicationException {
  public ReachTheMaximumAddressesPerUser() {
    super("ERROR-ADDRESS-0001", "Current user reached the maximum number of addresses per user!",
        HttpStatus.BAD_REQUEST);
  }
}
