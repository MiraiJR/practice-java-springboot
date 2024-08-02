package com.miraijr.examing.modules.user.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
  private Long id;
  private String fullName;
  private Email email;
  private List<Address> addresses;
  private PhoneNumber phoneNumber;
}
