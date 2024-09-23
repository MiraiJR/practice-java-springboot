package com.miraijr.examing.modules.user.application.port.in.output;

import com.miraijr.examing.modules.user.domain.User;

import lombok.Builder;

@Builder
public record UpdateUserOutputModel(
    Long id,
    String fullName,
    String email,
    String phoneNumber,
    Integer gender) {
  public static UpdateUserOutputModel convertFromDomain(User user) {
    return UpdateUserOutputModel.builder()
        .id(user.getId())
        .fullName(user.getFullName())
        .phoneNumber(user.getPhoneNumber() != null ? user.getPhoneNumber().getValue() : null)
        .email(user.getEmail() != null ? user.getEmail().getValue() : null)
        .gender(user.getGender() != null ? user.getGender().getValue() : null)
        .build();
  }
}
