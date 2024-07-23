package com.thanhtq.core.usecase.service;

import com.thanhtq.core.annotation.Usecase;
import com.thanhtq.core.domain.product.IProductRepository;
import com.thanhtq.core.domain.product.Product;
import com.thanhtq.core.usecase.model.ProductModel;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class CreateProductUseCase implements ICreateProductUseCase {
    private final IProductRepository productRepository;

    @Override
    public void createProduct(ProductModel productModel) {
        Product product = new Product(
                productModel.getTitle(),
                productModel.getSku(),
                productModel.getPrice()
        );
        productRepository.saveProduct(product);
    }
}
