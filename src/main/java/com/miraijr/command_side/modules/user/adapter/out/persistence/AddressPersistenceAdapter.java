package com.miraijr.command_side.modules.user.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.miraijr.command_side.modules.user.adapter.mapping.AddressMapping;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.AddressEntityJpa;
import com.miraijr.command_side.modules.user.adapter.out.persistence.jpa.AddressRepository;
import com.miraijr.command_side.modules.user.application.port.out.CreateUserAddressPort;
import com.miraijr.command_side.modules.user.domain.Address;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AddressPersistenceAdapter implements CreateUserAddressPort {
  private final AddressRepository addressRepository;
  private final AddressMapping addressMapping;

  @Override
  public Address createUserAddress(Address address) {
    AddressEntityJpa addressEntity = this.addressMapping.convertFromDomainEntityToJpaEntity(address);
    AddressEntityJpa savedAddress = this.addressRepository.save(addressEntity);
    return this.addressMapping.convertFromJpaEntityToDomainEntity(savedAddress);
  }
}
