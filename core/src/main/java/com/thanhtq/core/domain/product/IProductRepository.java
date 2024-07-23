package com.thanhtq.core.domain.product;

public interface IProductRepository {

    Product findByProductId(String productId);

    void saveProduct(Product product);
}
