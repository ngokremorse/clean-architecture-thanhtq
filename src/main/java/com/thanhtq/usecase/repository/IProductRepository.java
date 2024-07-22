package com.thanhtq.usecase.repository;

import com.thanhtq.domain.product.Product;

public interface IProductRepository {

    Product findByProductId(String productId);
}
