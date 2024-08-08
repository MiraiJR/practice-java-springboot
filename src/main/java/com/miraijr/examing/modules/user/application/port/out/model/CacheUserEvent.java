package com.miraijr.examing.modules.user.application.port.out.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.miraijr.examing.modules.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CacheUserEvent {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private List<CacheUserAddressEvent> addresses;

  public static CacheUserEvent covertFromDomainEntity(User user) {
    var builder = CacheUserEvent.builder()
        .id(user.getId())
        .fullName(user.getFullName());

    if (user.getEmail() != null) {
      builder.email(user.getEmail().getValue());
    }

    if (user.getPhoneNumber() != null) {
      builder.phoneNumber(user.getPhoneNumber().getValue());
    }

    if (user.getAddresses() != null) {
      builder.addresses(user.getAddresses()
          .stream()
          .map(CacheUserAddressEvent::convertFromDomain)
          .collect(Collectors.toList()));
    } else {
      builder.addresses(Collections.emptyList());
    }

    return builder.build();
  }
}
