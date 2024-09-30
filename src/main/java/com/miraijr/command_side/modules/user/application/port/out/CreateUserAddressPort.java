package com.miraijr.command_side.modules.user.application.port.out;

import com.miraijr.command_side.modules.user.domain.Address;

public interface CreateUserAddressPort {
  Address createUserAddress(Address address);
}
