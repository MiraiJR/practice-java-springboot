package com.miraijr.examing.modules.user.application;

import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.miraijr.examing.modules.user.application.exceptions.ReachTheMaximumAddressesPerUser;
import com.miraijr.examing.modules.user.application.exceptions.UserNotFoundException;
import com.miraijr.examing.modules.user.application.port.in.CreateUserAddressUseCase;
import com.miraijr.examing.modules.user.application.port.in.input.CreateUserAddressInputModel;
import com.miraijr.examing.modules.user.application.port.in.output.UserAddressOutputModel;
import com.miraijr.examing.modules.user.application.port.out.CreateUserAddressPort;
import com.miraijr.examing.modules.user.application.port.out.LoadUserPort;
import com.miraijr.examing.modules.user.application.port.out.SendEventToMessageQueuePort;
import com.miraijr.examing.modules.user.application.port.out.model.CacheUserEvent;
import com.miraijr.examing.modules.user.domain.Address;
import com.miraijr.examing.modules.user.domain.AddressType;
import com.miraijr.examing.modules.user.domain.User;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUserAddress implements CreateUserAddressUseCase {
  private final static Integer MAX_ADDRESSES = 5;

  private final CreateUserAddressPort createUserAddressPort;
  private final LoadUserPort loadUserPort;
  private final SendEventToMessageQueuePort sendEventToMessageQueuePort;

  @Override
  @Transactional("transactionManager")
  public UserAddressOutputModel createAddress(Long userId, CreateUserAddressInputModel inputModel) {
    Optional<User> matchedUser = this.loadUserPort.loadUser(userId);

    if (matchedUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    if (matchedUser.get().getAddresses().size() >= MAX_ADDRESSES) {
      throw new ReachTheMaximumAddressesPerUser();
    }

    Address address = Address.builder()
        .province(inputModel.getProvince())
        .district(inputModel.getDistrict())
        .ward(inputModel.getWard())
        .homeAddress(inputModel.getHomeAddress())
        .type(new AddressType(inputModel.getType()))
        .userId(matchedUser.get().getId())
        .build();
    Address newAddress = this.createUserAddressPort.createUserAddress(address);
    matchedUser.get().addNewAddress(newAddress);
    this.sendEventToMessageQueuePort.cacheUser(CacheUserEvent.covertFromDomainEntity(matchedUser.get()));
    return UserAddressOutputModel.convertFromDomain(newAddress);
  }
}
