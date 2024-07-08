package com.miraijr.examing.modules.account.adapter.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.account.application.port.in.RegisterAccountInputModel;
import com.miraijr.examing.modules.account.application.port.in.RegisterAccountUseCase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController()
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
  private final RegisterAccountUseCase registerAccountUseCase;

  @PostMapping()
  public String registerAccount(@Valid @RequestBody RegisterAccountInputModel registerAccount) {
    return registerAccountUseCase.execute(registerAccount);
  }
}
