package com.miraijr.command_side.modules.user.domain.exceptions;

import com.miraijr.command_side.core.domain.DomainException;

public class InvalidGender extends DomainException {
    public InvalidGender() {
        super("DOMAIN-USER-ERROR-0004", "Invalid gender");
    }
}
