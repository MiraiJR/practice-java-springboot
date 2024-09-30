package com.miraijr.command_side.modules.user.adapter.out.persistence.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntityRedis {
  private Long id;
  private String province;
  private String district;
  private String ward;
  private String homeAddress;
  private Integer type;
}
