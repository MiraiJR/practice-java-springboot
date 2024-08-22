package com.miraijr.examing.modules.product.application;

import java.util.List;
import org.springframework.stereotype.Component;
import com.miraijr.examing.modules.product.application.port.in.GetRecommendProductUseCase;
import com.miraijr.examing.modules.product.application.port.in.input.GetRecommendProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.GetRecommendProductOutputModel;
import com.miraijr.examing.modules.product.application.port.out.LoadRecommendProductNamePort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetRecommendProductService implements GetRecommendProductUseCase {
    private final LoadRecommendProductNamePort loadRecommendProductNamePort;

    @Override
    public GetRecommendProductOutputModel getRecommendProduct(GetRecommendProductInputModel inputModel) {
        List<String> recommendProductNameList = this.loadRecommendProductNamePort
                .loadRecommendProductName(inputModel.getPrompt());

        return GetRecommendProductOutputModel
                .builder()
                .query(inputModel.getPrompt())
                .result(recommendProductNameList)
                .build();
    }
}
