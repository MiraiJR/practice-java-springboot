package com.miraijr.examing.modules.account.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.account.application.port.in.LoginAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.RegisterAccountUseCase;
import com.miraijr.examing.modules.account.application.port.in.input.LoginAccountInputModel;
import com.miraijr.examing.modules.account.application.port.in.input.RegisterAccountInputModel;
import com.miraijr.examing.modules.account.application.port.in.output.LoginAccountOutputModel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController()
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
  private final RegisterAccountUseCase registerAccountUseCase;
  private final LoginAccountUseCase loginAccountUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/register")
  public String registerAccount(@Valid @RequestBody RegisterAccountInputModel registerAccount) {
    return registerAccountUseCase.execute(registerAccount);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/login")
  public LoginAccountOutputModel loginAccount(@Valid @RequestBody LoginAccountInputModel loginAccountInputModel) {
    return loginAccountUseCase.execute(loginAccountInputModel);
  }
}
