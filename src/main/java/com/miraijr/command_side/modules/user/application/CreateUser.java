package com.miraijr.command_side.modules.user.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.command_side.modules.user.application.exceptions.ExistedUserWithIdException;
import com.miraijr.command_side.modules.user.application.port.in.CreateUserUseCase;
import com.miraijr.command_side.modules.user.application.port.in.input.CreateUserInputModel;
import com.miraijr.command_side.modules.user.application.port.out.CreateUserPort;
import com.miraijr.command_side.modules.user.application.port.out.LoadUserPort;
import com.miraijr.command_side.modules.user.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.command_side.modules.user.application.port.out.model.CompleteCreateUserEvent;
import com.miraijr.command_side.modules.user.application.port.out.model.ReverseAccountEvent;
import com.miraijr.command_side.modules.user.common.types.enums.EventStatus;
import com.miraijr.command_side.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUser implements CreateUserUseCase {
  private final CreateUserPort createUserPort;
  private final LoadUserPort loadUserPort;
  private final SendEventToMessageQueuePort sendEventToMessageQueuePort;

  @Override
  @Transactional("transactionManager")
  public void execute(CreateUserInputModel createUserInputModel) {
    try {
      Optional<User> matchedUser = this.loadUserPort.loadUser(createUserInputModel.getId());

      if (matchedUser.isPresent()) {
        throw new ExistedUserWithIdException();
      }

      User user = User.builder()
          .id(createUserInputModel.getId())
          .fullName(createUserInputModel.getFullName())
          .build();
      User newUser = this.createUserPort.createUser(user);
      this.sendEventToMessageQueuePort
          .completeCreateUser(new CompleteCreateUserEvent(newUser.getId(), EventStatus.COMPLETED));
      this.sendEventToMessageQueuePort.cacheUser(newUser);
    } catch (Exception e) {
      this.sendEventToMessageQueuePort
          .reverseAccount(new ReverseAccountEvent(createUserInputModel.getId(), EventStatus.REVERSE_ACCOUNT));
    }
  }
}
