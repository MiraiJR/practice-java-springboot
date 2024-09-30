package com.miraijr.command_side.modules.user.application.port.in.output;

import com.miraijr.command_side.modules.user.domain.Address;

import lombok.Builder;

@Builder
public record UserAddressOutputModel(
    Long id,
    String province,
    String district,
    String ward,
    String homeAddress,
    Integer type) {
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
