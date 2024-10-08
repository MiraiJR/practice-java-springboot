package com.miraijr.command_side.modules.product.application.port.in;

import com.miraijr.command_side.modules.product.application.port.in.input.CreateCategoryInputModel;
import com.miraijr.command_side.modules.product.application.port.in.output.CreateCategoryOutputModel;

public interface CreateCategoryUseCase {
  CreateCategoryOutputModel execute(CreateCategoryInputModel inputModel);
}
