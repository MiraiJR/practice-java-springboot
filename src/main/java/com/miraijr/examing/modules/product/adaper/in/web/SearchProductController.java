package com.miraijr.examing.modules.product.adaper.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.miraijr.examing.modules.product.application.port.in.GetRecommendProductUseCase;
import com.miraijr.examing.modules.product.application.port.in.input.GetRecommendProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.GetRecommendProductOutputModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class SearchProductController {
    private final GetRecommendProductUseCase getRecommendProductUseCase;

    @GetMapping("/recommend")
    public GetRecommendProductOutputModel getListRecommendProductName(
            @Valid @ModelAttribute GetRecommendProductInputModel inputData) {
        return this.getRecommendProductUseCase.getRecommendProduct(inputData);
    }
}
