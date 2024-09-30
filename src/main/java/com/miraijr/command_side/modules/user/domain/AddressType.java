package com.miraijr.command_side.modules.user.domain;

import java.util.Arrays;
import java.util.List;

import com.miraijr.command_side.modules.user.domain.exceptions.InvalidAddressType;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddressType {
  public static final Integer PRIVATE_HOME = 0;
  public static final Integer OFFICE = 1;
  private static final List<Integer> ACCEPTANCE_ADDRESS_TYPES = Arrays.asList(PRIVATE_HOME, OFFICE);
  private Integer value;

  public AddressType(Integer value) {
    this.setValue(value);
  }

  private void setValue(Integer value) {
    if (!ACCEPTANCE_ADDRESS_TYPES.contains(value)) {
      throw new InvalidAddressType();
    }

    this.value = value;
  }
}
