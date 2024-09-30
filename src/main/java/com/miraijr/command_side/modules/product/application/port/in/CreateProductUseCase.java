package com.miraijr.command_side.modules.product.application.port.in;

import com.miraijr.command_side.modules.product.application.port.in.input.CreateProductInputModel;
import com.miraijr.command_side.modules.product.application.port.in.output.CreateProductOutputModel;

public interface CreateProductUseCase {
  CreateProductOutputModel execute(CreateProductInputModel inputModel);
}
