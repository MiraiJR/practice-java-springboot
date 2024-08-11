package com.miraijr.examing.modules.user.domain.exceptions;

import com.miraijr.examing.core.domain.DomainException;

public class InvalidGender extends DomainException {
    public InvalidGender() {
        super("DOMAIN-USER-ERROR-0004", "Invalid gender");
    }
}
