package com.thanhtq.core.domain.product.repository;

import com.thanhtq.core.domain.product.Product;

public interface IProductRepository {

    boolean exits(String productId);
    void saveProduct(Product product);
}
