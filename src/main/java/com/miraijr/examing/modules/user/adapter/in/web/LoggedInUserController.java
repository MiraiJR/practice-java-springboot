package com.miraijr.examing.modules.user.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.user.application.port.in.GetUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.output.FullInformationUserOutputModel;
import com.miraijr.examing.shared.annotations.interfaces.UserId;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users/me")
@AllArgsConstructor
public class LoggedInUserController {
  private final GetUserUseCase getUserUseCase;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public FullInformationUserOutputModel getLoggedInUser(@UserId() Long userId) {
    return this.getUserUseCase.loggedInUser(userId);
  }
}
