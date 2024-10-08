package com.miraijr.command_side.modules.product.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
  private Date createdAt;
  private Date updatedAt;
  private List<Category> childrens;

  public Category(Long id) {
    this.id = id;
  }

  public void addChildren(Category category) {
    if (this.childrens == null) {
      this.childrens = new ArrayList<>();
    }

    this.childrens.add(category);
  }
}
