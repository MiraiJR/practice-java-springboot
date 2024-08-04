package com.miraijr.examing.modules.user.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Long id;
  private String fullName;
  private Email email;
  private List<Address> addresses;
  private PhoneNumber phoneNumber;

  public void addNewAddress(Address address) {
    this.addresses.add(address);
  }
}
