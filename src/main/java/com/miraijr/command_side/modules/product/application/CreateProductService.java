package com.miraijr.command_side.modules.product.application;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.miraijr.command_side.core.infrastruction.external_services.out.SlugGeneratorPort;
import com.miraijr.command_side.modules.product.application.exceptions.CategoryNotFound;
import com.miraijr.command_side.modules.product.application.port.in.CreateProductUseCase;
import com.miraijr.command_side.modules.product.application.port.in.input.CreateProductInputModel;
import com.miraijr.command_side.modules.product.application.port.in.output.CreateProductOutputModel;
import com.miraijr.command_side.modules.product.application.port.out.CreateProductPort;
import com.miraijr.command_side.modules.product.application.port.out.LoadCategoryPort;
import com.miraijr.command_side.modules.product.application.port.out.SendProductEventToMessageQueuePort;
import com.miraijr.command_side.modules.product.domain.Category;
import com.miraijr.command_side.modules.product.domain.Price;
import com.miraijr.command_side.modules.product.domain.Product;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateProductService implements CreateProductUseCase {
  private final CreateProductPort createProductPort;
  private final LoadCategoryPort loadCategoryPort;
  private final SlugGeneratorPort slugGeneratorPort;
  private final SendProductEventToMessageQueuePort sendProductEventToMessageQueuePort;

  @Override
  @Transactional("transactionManager")
  public CreateProductOutputModel execute(CreateProductInputModel inputModel) {
    Optional<Category> matchedCategory = this.loadCategoryPort.loadCategory(inputModel.getCategoryId());

    if (matchedCategory.isEmpty()) {
      throw new CategoryNotFound();
    }

    Product product = Product.builder()
        .name(inputModel.getName())
        .description(inputModel.getDescription())
        .price(new Price(inputModel.getPrice()))
        .stock(inputModel.getStock())
        .category(matchedCategory.get())
        .slug(this.slugGeneratorPort.generateSlug(inputModel.getName()))
        .build();

    Product newProduct = this.createProductPort.createProduct(product);

    this.sendProductEventToMessageQueuePort.sendProductToExternalService(newProduct);

    return CreateProductOutputModel.convertFromDomainEntity(newProduct);
  }
}
