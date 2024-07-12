package com.miraijr.examing.modules.user.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.application.exceptions.ExistedUserWithIdException;
import com.miraijr.examing.modules.user.application.port.in.CreateUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.CreateUserInputModel;
import com.miraijr.examing.modules.user.application.port.out.CreateUserPort;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUser implements CreateUserUseCase {
  private final CreateUserPort createUserPort;
  private final LoadUserPort loadUserPort;

  @Override
  public void execute(CreateUserInputModel createUserInputModel) {
    Optional<User> matchedUser = this.loadUserPort.loadUser(createUserInputModel.getId());

    if (matchedUser.isPresent()) {
      throw new ExistedUserWithIdException();
    }

    User user = new User(createUserInputModel.getId(), createUserInputModel.getFullName());
    this.createUserPort.createUser(user);
  }
}
