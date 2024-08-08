package com.miraijr.examing.modules.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private Long id;
  private String province;
  private String district;
  private String ward;
  private String homeAddress;
  private AddressType type;
  private Long userId;
}
