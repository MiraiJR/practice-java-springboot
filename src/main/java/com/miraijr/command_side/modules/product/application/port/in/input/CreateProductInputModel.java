package com.miraijr.command_side.modules.product.application.port.in.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductInputModel {
  @NotNull
  @NotEmpty
  private String name;
  @NotNull
  @NotEmpty
  private String description;
  @NotNull
  @Min(0)
  private Float price;
  @NotNull
  @Min(0)
  private Long stock;
  @NotNull
  private Long categoryId;
}
