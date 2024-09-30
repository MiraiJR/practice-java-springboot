package com.miraijr.command_side.modules.product.application.port.in.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryInputModel {
  private Long parentId;
  @NotEmpty
  @NotNull
  private String name;
}
