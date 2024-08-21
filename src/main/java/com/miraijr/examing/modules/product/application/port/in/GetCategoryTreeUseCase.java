package com.miraijr.examing.modules.product.application.port.in;

import java.util.List;

import com.miraijr.examing.modules.product.application.port.in.output.GetCategoryTreeUseCaseOutputModel;

public interface GetCategoryTreeUseCase {
  List<GetCategoryTreeUseCaseOutputModel> getCategoriesTreeView();
}
