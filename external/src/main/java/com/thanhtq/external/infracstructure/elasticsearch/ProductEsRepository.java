package com.thanhtq.external.infracstructure.elasticsearch;

import com.thanhtq.core.domain.product.IProductRepository;
import com.thanhtq.core.domain.product.Product;
import com.thanhtq.external.infracstructure.elasticsearch.document.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductEsRepository implements IProductRepository {
    private final ESRepository esRepository;

    @Override
    public Product findByProductId(String productId) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        ProductDocument productDocument = new ProductDocument();
        BeanUtils.copyProperties(product, productDocument);
        esRepository.save(productDocument);
    }
}