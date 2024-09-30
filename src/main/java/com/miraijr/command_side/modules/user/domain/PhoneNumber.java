package com.miraijr.command_side.modules.user.domain;

import com.miraijr.command_side.modules.user.domain.exceptions.InvalidPhoneNumber;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PhoneNumber {
  private static final String PHONE_NUMBER_PATTERN = "^\\+?[0-9]{1,3}?[-.\\s]?[0-9]{1,4}?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,9}$";
  private String value;

  public PhoneNumber(String value) {
    this.setValue(value);
  }

  private void setValue(String value) {
    if (value.isEmpty() || !value.matches(PHONE_NUMBER_PATTERN)) {
      throw new InvalidPhoneNumber();
    }

    this.value = value;
  }
}
