package com.miraijr.examing.modules.product.adaper.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.product.application.port.in.CreateCategoryUseCase;
import com.miraijr.examing.modules.product.application.port.in.GetCategoryTreeUseCase;
import com.miraijr.examing.modules.product.application.port.in.input.CreateCategoryInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.CreateCategoryOutputModel;
import com.miraijr.examing.modules.product.application.port.in.output.GetCategoryTreeUseCaseOutputModel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
  private final CreateCategoryUseCase createCategoryUseCase;
  private final GetCategoryTreeUseCase getCategoryTreeUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CreateCategoryOutputModel createCategory(@Valid @RequestBody CreateCategoryInputModel inputData) {
    return this.createCategoryUseCase.execute(inputData);
  }

  @GetMapping()
  public List<GetCategoryTreeUseCaseOutputModel> getCategories() {
    return this.getCategoryTreeUseCase.getCategoriesTreeView();
  }
}
