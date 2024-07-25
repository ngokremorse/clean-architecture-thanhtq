package com.thanhtq.core.service;

import com.thanhtq.core.domain.core.EventStore;
import com.thanhtq.core.domain.product.event.ProductEvent;
import com.thanhtq.core.domain.product.service.ICreateProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements ICreateProductService {
    private final EventStore eventStore;

    @Override
    public void createProduct(ProductEvent productEvent) {
        eventStore.save(productEvent);
    }
}
