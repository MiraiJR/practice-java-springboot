package com.miraijr.examing.modules.account.application.port.out.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserInputModel {
    private Long id;
    private String fullName;
}
