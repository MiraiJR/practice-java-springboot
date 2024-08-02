package com.miraijr.examing.modules.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
  private Long id;
  private String province;
  private String district;
  private String ward;
  private String homeAddress;
  private AddressType type;
  private Long userId;
}
