package com.thanhtq.external.infracstructure.elasticsearch.repository;

import com.thanhtq.core.domain.product.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EsProductDefaultRepository implements IProductRepository {
    private final EsProductRepository productRepository;

    @Override
    public boolean exits(String productId) {
        return productRepository.existsByProductId(productId);
    }
}
