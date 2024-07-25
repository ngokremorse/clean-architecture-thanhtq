package com.thanhtq.core.domain.product.service;


import com.thanhtq.core.domain.product.event.ProductEvent;

public interface ICreateProductService {
    void createProduct(ProductEvent productEvent);
}
