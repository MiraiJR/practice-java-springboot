package com.miraijr.command_side.modules.user.domain;

import com.miraijr.command_side.modules.user.domain.exceptions.InvalidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Email {
  private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

  private String value;

  public Email(String value) {
    this.setValue(value);
  }

  private void setValue(String value) {
    if (value.isEmpty() || !value.matches(EMAIL_PATTERN)) {
      throw new InvalidEmail();
    }

    this.value = value;
  }
}
