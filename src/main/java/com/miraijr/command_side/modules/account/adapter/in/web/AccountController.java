package com.miraijr.command_side.modules.account.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.command_side.modules.account.application.port.in.LoginAccountUseCase;
import com.miraijr.command_side.modules.account.application.port.in.LogoutAccountUseCase;
import com.miraijr.command_side.modules.account.application.port.in.RegisterAccountUseCase;
import com.miraijr.command_side.modules.account.application.port.in.input.LoginAccountInputModel;
import com.miraijr.command_side.modules.account.application.port.in.input.RegisterAccountInputModel;
import com.miraijr.command_side.modules.account.application.port.in.output.LoginAccountOutputModel;
import com.miraijr.command_side.shared.annotations.interfaces.UserId;

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
  private final LogoutAccountUseCase logoutAccountUseCase;

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

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/logout")
  public String logoutAccount(@UserId Long userId) {
    return logoutAccountUseCase.execute(userId);
  }
}
