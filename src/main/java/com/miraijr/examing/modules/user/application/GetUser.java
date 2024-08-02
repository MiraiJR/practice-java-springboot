package com.miraijr.examing.modules.user.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.miraijr.examing.modules.user.application.exceptions.UserNotFoundException;
import com.miraijr.examing.modules.user.application.port.in.GetUserUseCase;
import com.miraijr.examing.modules.user.application.port.in.output.FullInformationUserOutputModel;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetUser implements GetUserUseCase {
  private final LoadUserPort loadUserPort;

  @Override
  public FullInformationUserOutputModel loggedInUser(Long userId) {
    Optional<User> matchedUser = this.loadUserPort.loadUser(userId);

    if (matchedUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    return FullInformationUserOutputModel.convertFromDomain(matchedUser.get());
  }
}
