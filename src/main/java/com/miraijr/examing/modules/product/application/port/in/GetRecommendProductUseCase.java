package com.miraijr.examing.modules.product.application.port.in;

import com.miraijr.examing.modules.product.application.port.in.input.GetRecommendProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.GetRecommendProductOutputModel;

public interface GetRecommendProductUseCase {
    GetRecommendProductOutputModel getRecommendProduct(GetRecommendProductInputModel inputModel);
}
