package com.thanhtq.core.service;

import com.thanhtq.core.domain.product.event.ProductEvent;
import com.thanhtq.core.domain.product.repository.IProductRepository;
import com.thanhtq.core.domain.product.service.ICreateProductService;
import com.thanhtq.core.domain.product.service.IUpdateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements IUpdateProductService {
    private final IProductRepository productRepository;

    @Override
    public boolean exits(String productId) {
        return productRepository.exits(productId);
    }

    @Override
    public void updateProductService(ProductEvent productEvent) {

    }
}
