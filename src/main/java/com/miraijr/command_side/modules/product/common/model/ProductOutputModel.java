package com.miraijr.command_side.modules.product.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOutputModel {
  protected Long id;
  protected String name;
  protected String description;
  protected Float price;
  protected Long stock;
  protected String slug;
}
