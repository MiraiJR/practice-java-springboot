package com.miraijr.command_side.modules.user.application.port.out.model;

import com.miraijr.command_side.modules.user.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CacheUserAddressEvent {
  private Long id;
  private String province;
  private String district;
  private String ward;
  private String homeAddress;
  private Integer type;

  public static CacheUserAddressEvent convertFromDomain(Address domain) {
    return CacheUserAddressEvent.builder()
        .id(domain.getId())
        .province(domain.getProvince())
        .district(domain.getDistrict())
        .ward(domain.getWard())
        .homeAddress(domain.getHomeAddress())
        .type(domain.getType().getValue())
        .build();
  }
}
