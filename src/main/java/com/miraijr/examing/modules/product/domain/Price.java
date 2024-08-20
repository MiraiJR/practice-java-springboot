package com.miraijr.examing.modules.product.domain;

import com.miraijr.examing.modules.product.domain.exceptions.InvalidPrice;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Price {
  private Float value;

  public Price(Float value) {
    this.setPrice(value);
  }

  public Price(Double value) {
    this.setPrice(value.floatValue());
  }

  private void setPrice(Float value) {
    if (value <= 0) {
      throw new InvalidPrice();
    }

    this.value = value;
  }
}
