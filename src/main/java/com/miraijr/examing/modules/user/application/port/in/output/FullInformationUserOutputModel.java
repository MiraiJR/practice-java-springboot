package com.miraijr.examing.modules.user.application.port.in.output;

import java.util.List;
import java.util.stream.Collectors;
import com.miraijr.examing.modules.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FullInformationUserOutputModel {
  private Long id;
  private String fullName;
  private String email;
  private String phoneNumber;
  private List<UserAddressOutputModel> addresses;

  public static FullInformationUserOutputModel convertFromDomain(User user) {
    return FullInformationUserOutputModel.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .phoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber().getValue() : null)
        .email(user.getEmail() != null ? user.getEmail().getValue() : null)
        .addresses(user.getAddresses() != null ? user.getAddresses().stream()
            .map(UserAddressOutputModel::convertFromDomain)
            .collect(Collectors.toList()) : List.of())
        .build();
  }
}
