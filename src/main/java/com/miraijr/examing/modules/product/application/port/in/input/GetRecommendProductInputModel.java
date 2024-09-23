package com.miraijr.examing.modules.product.application.port.in.input;

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
public class GetRecommendProductInputModel {
    @NotNull
    @NotEmpty
    private String prompt;
    private Float minPrice;
    private Float maxPrice;
}
