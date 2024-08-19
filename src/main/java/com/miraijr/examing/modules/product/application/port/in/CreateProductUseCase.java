package com.miraijr.examing.modules.product.application.port.in;

import com.miraijr.examing.modules.product.application.port.in.input.CreateProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.CreateProductOutputModel;

public interface CreateProductUseCase {
  CreateProductOutputModel execute(CreateProductInputModel inputModel);
}
