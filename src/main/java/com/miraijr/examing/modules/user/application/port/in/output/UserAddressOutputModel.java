package com.miraijr.examing.modules.user.application.port.in.output;

import com.miraijr.examing.modules.user.domain.Address;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserAddressOutputModel {
  private Long id;
  private String province;
  private String district;
  private String ward;
  private String homeAddress;
  private Integer type;

  public static UserAddressOutputModel convertFromDomain(Address address) {
    return UserAddressOutputModel.builder()
        .id(address.getId())
        .province(address.getProvince())
        .district(address.getDistrict())
        .ward(address.getWard())
        .homeAddress(address.getHomeAddress())
        .type(address.getType().getValue())
        .build();
  }
}
