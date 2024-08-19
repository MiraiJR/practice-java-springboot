package com.miraijr.examing.modules.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  private Long id;
  private Category parent;
  private String name;
  private String slug;
}
