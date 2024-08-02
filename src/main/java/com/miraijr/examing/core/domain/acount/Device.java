package com.miraijr.examing.core.domain.acount;

import java.util.Arrays;
import java.util.List;

import com.miraijr.examing.core.domain.acount.exceptions.InvalidDevice;
import com.miraijr.examing.shared.types.enums.DeviceType;
import lombok.Getter;

@Getter
public class Device {
  private final List<String> ACCEPTANCE_DEVICES = Arrays.asList(DeviceType.DESKTOP.name(), DeviceType.MOBILE.name(),
      DeviceType.TABLET.name(), DeviceType.OTHER.name());
  private String value;

  public Device(String value) {
    this.setValue(value);
  }

  private void setValue(String value) {
    if (!ACCEPTANCE_DEVICES.contains(value)) {
      throw new InvalidDevice();
    }

    this.value = value;
  }

  public boolean isMobile() {
    return this.value.equals(DeviceType.MOBILE.name());
  }

  public boolean isDesktop() {
    return this.value.equals(DeviceType.DESKTOP.name());
  }

  public boolean isTablet() {
    return this.value.equals(DeviceType.TABLET.name());
  }

  public boolean isOther() {
    return this.value.equals(DeviceType.OTHER.name());
  }
}
