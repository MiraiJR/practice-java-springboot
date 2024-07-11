package com.miraijr.examing.modules.account.application.port.out.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserInputModel {
    private Long id;
    private String fullName;
}
