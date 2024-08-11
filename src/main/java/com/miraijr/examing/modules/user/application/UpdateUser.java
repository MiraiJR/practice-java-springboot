package com.miraijr.examing.modules.user.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.examing.modules.user.application.exceptions.UserNotFoundException;
import com.miraijr.examing.modules.user.application.port.in.UpdateUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.UpdateUserInputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UpdateUserOutputModel;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.examing.modules.user.application.port.out.UpdateUserPort;
import com.miraijr.examing.modules.user.application.port.out.model.CacheUserEvent;
import com.miraijr.examing.modules.user.domain.Email;
import com.miraijr.examing.modules.user.domain.Gender;
import com.miraijr.examing.modules.user.domain.PhoneNumber;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateUser implements UpdateUserUseCase {
  private final LoadUserPort loadUserPort;
  private final UpdateUserPort updateUserPort;
  private final SendEventToMessageQueuePort sendEventToMessageQueuePort;

  @Override
  @Transactional("transactionManager")
  public UpdateUserOutputModel updateUser(Long userId, UpdateUserInputModel inputModel) {
    Optional<User> matchedUser = this.loadUserPort.loadUser(userId);

    if (matchedUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    User newProfileUser = User.builder()
        .id(userId)
        .email(new Email(inputModel.getEmail()))
        .phoneNumber(new PhoneNumber(inputModel.getPhoneNumber()))
        .gender(new Gender(inputModel.getGender()))
        .fullName(inputModel.getFullName())
        .build();
    User updatedUser = this.updateUserPort.updateUser(newProfileUser);

    this.sendEventToMessageQueuePort.cacheUser(CacheUserEvent.covertFromDomainEntity(updatedUser));

    return UpdateUserOutputModel.convertFromDomain(updatedUser);
  }
}
