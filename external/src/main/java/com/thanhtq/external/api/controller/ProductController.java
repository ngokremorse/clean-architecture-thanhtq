package com.thanhtq.external.api.controller;

import com.thanhtq.core.usecase.model.ProductModel;
import com.thanhtq.core.usecase.service.ICreateProductUseCase;
import com.thanhtq.external.api.dto.ProductCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ICreateProductUseCase iCreateProductUseCase;
    public String createProduct(ProductCreateCommand productCreateCommand) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productCreateCommand, productModel);
        iCreateProductUseCase.createProduct(productModel);
        return "Create product success!";
    }
}
