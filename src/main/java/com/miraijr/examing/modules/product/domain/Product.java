package com.miraijr.examing.modules.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  private Long id;
  private String name;
  private String description;
  private Price price;
  private Long stock;
  private String slug;
  private Category category;
}
