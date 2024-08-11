package com.miraijr.examing.modules.user.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.user.application.port.in.CreateUserAddressUseCase;
import com.miraijr.examing.modules.user.application.port.in.GetUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.UpdateUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.CreateUserAddressInputModel;
import com.miraijr.examing.modules.user.application.port.in.input.UpdateUserInputModel;
import com.miraijr.examing.modules.user.application.port.in.output.FullInformationUserOutputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UpdateUserOutputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UserAddressOutputModel;
import com.miraijr.examing.shared.annotations.interfaces.UserId;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/users/me")
@AllArgsConstructor
public class LoggedInUserController {
  private final GetUserUseCase getUserUseCase;
  private final CreateUserAddressUseCase createUserAddressUseCase;
  private final UpdateUserUseCase updateUserUseCase;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping()
  public FullInformationUserOutputModel getLoggedInUser(@UserId() Long userId) {
    return this.getUserUseCase.loggedInUser(userId);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping()
  public UpdateUserOutputModel updateUserProfile(@UserId() Long userId,
      @Valid @RequestBody UpdateUserInputModel inputData) {
    return updateUserUseCase.updateUser(userId, inputData);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/addresses")
  public UserAddressOutputModel createAddress(@UserId Long userId,
      @Valid @RequestBody CreateUserAddressInputModel inputData) {
    return this.createUserAddressUseCase.createAddress(userId, inputData);
  }
}
