package com.thanhtq.core.domain.product.service;


import com.thanhtq.core.domain.product.event.ProductEvent;

public interface IUpdateProductService {
    boolean exits(String productId);
    void updateProductService(ProductEvent productEvent);
}
