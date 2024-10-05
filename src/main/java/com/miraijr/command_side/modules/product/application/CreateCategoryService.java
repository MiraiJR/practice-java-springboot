package com.miraijr.command_side.modules.product.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.command_side.core.infrastruction.external_services.out.SlugGeneratorPort;
import com.miraijr.command_side.modules.product.application.port.in.CreateCategoryUseCase;
import com.miraijr.command_side.modules.product.application.port.in.input.CreateCategoryInputModel;
import com.miraijr.command_side.modules.product.application.port.in.output.CreateCategoryOutputModel;
import com.miraijr.command_side.modules.product.application.port.out.CreateCategoryPort;
import com.miraijr.command_side.modules.product.application.port.out.LoadCategoryPort;
import com.miraijr.command_side.modules.product.application.port.out.SendCategoryEventToMessageQueuePort;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Category.CategoryBuilder;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateCategoryService implements CreateCategoryUseCase {
  private final LoadCategoryPort loadCategoryPort;
  private final CreateCategoryPort createCategoryPort;
  private final SlugGeneratorPort slugGeneratorPort;
  private final SendCategoryEventToMessageQueuePort SendCategoryEventToMessageQueuePort;

  @Override
  @Transactional("transactionManager")
  public CreateCategoryOutputModel execute(CreateCategoryInputModel inputModel) {
    CategoryBuilder builder = Category.builder();
    builder.name(inputModel.getName());
    builder.slug(this.slugGeneratorPort.generateSlug(inputModel.getName()));

    if (inputModel.getParentId() != null) {
      Optional<Category> matchedCategory = this.loadCategoryPort.loadCategory(inputModel.getParentId());
      if (matchedCategory.isPresent()) {
        builder.parent(matchedCategory.get());
      }
    }

    Category newCategory = this.createCategoryPort.createCategory(builder.build());

    this.SendCategoryEventToMessageQueuePort.sendCategoryToExternalService(newCategory);

    return CreateCategoryOutputModel.convertFromDomain(newCategory);
  }
}
