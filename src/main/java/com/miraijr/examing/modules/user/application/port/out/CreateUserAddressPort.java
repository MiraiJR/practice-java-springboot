package com.miraijr.examing.modules.user.application.port.out;

import com.miraijr.examing.modules.user.domain.Address;

public interface CreateUserAddressPort {
  Address createUserAddress(Address address);
}
