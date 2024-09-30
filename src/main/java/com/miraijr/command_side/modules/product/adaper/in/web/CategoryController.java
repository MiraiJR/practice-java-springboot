package com.miraijr.command_side.modules.product.adaper.in.web;

import org.springframework.web.bind.annotation.RestController;

import com.miraijr.command_side.modules.product.application.port.in.CreateCategoryUseCase;
import com.miraijr.command_side.modules.product.application.port.in.input.CreateCategoryInputModel;
import com.miraijr.command_side.modules.product.application.port.in.output.CreateCategoryOutputModel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
  private final CreateCategoryUseCase createCategoryUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public CreateCategoryOutputModel createCategory(@Valid @RequestBody CreateCategoryInputModel inputData) {
    return this.createCategoryUseCase.execute(inputData);
  }
}
