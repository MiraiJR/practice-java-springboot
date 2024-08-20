package com.miraijr.examing.modules.product.adaper.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miraijr.examing.modules.product.application.port.in.CreateProductUseCase;
import com.miraijr.examing.modules.product.application.port.in.input.CreateProductInputModel;
import com.miraijr.examing.modules.product.application.port.in.output.CreateProductOutputModel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
  private final CreateProductUseCase createProductUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping()
  public CreateProductOutputModel createProduct(@Valid @RequestBody CreateProductInputModel inputData) {
    return this.createProductUseCase.execute(inputData);
  }
}
