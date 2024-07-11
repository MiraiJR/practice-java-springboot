package com.miraijr.examing.modules.account.application.exceptions;

import org.springframework.http.HttpStatus;

import com.miraijr.examing.core.application.ApplicationException;

public class FailToRegisterAccountException extends ApplicationException {
    public FailToRegisterAccountException() {
        super("REFISTER-ACCOUNT-ERROR-0002", "Something is error in processing register account!",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
