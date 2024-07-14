package com.miraijr.examing.modules.account.domain;

import java.util.Arrays;
import java.util.List;

import com.miraijr.examing.modules.account.domain.exceptions.InvalidStatus;

import lombok.Getter;

@Getter
public class Status {
  private final List<String> ACCEPTANCE_STATUS = Arrays.asList("PENDING", "ACTIVE", "FAILED");
  private String value;

  public Status(String value) {
    this.setValue(value);
  }

  private void setValue(String value) {
    if (!ACCEPTANCE_STATUS.contains(value)) {
      throw new InvalidStatus();
    }

    this.value = value;
  }

  public boolean isFailed() {
    return this.value == "FAILED";
  }
}
