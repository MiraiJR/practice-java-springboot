package com.miraijr.examing.modules.user.application.port.in.output;

import java.util.List;
import java.util.stream.Collectors;
import com.miraijr.examing.modules.user.domain.User;
import lombok.Builder;

@Builder
public record FullInformationUserOutputModel(
    Long id,
    String fullName,
    String email,
    String phoneNumber,
    Integer gender,
    List<UserAddressOutputModel> addresses) {
  public static FullInformationUserOutputModel convertFromDomain(User user) {
    return FullInformationUserOutputModel.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .phoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber().getValue() : null)
        .email(user.getEmail() != null ? user.getEmail().getValue() : null)
        .gender(user.getGender() != null ? user.getGender().getValue() : null)
        .addresses(user.getAddresses() != null ? user.getAddresses().stream()
            .map(UserAddressOutputModel::convertFromDomain)
            .collect(Collectors.toList()) : List.of())
        .build();
  }
}
