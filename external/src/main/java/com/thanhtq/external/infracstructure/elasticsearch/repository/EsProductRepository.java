package com.thanhtq.external.infracstructure.elasticsearch.repository;

import com.thanhtq.core.domain.product.Product;
import com.thanhtq.core.domain.product.repository.IProductRepository;
import com.thanhtq.external.infracstructure.elasticsearch.document.MoneyObject;
import com.thanhtq.external.infracstructure.elasticsearch.document.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EsProductRepository implements IProductRepository {
    private final IEsProductRepository esProductRepository;

    @Override
    public boolean exits(String productId) {
        return esProductRepository.existsByProductId(productId);
    }

    @Override
    public void saveProduct(Product product) {
        ProductDocument productDocument = new ProductDocument();
        BeanUtils.copyProperties(product, productDocument);
        productDocument.setPrice(
                new MoneyObject(
                        product.getPrice().getCurrencyCode(),
                        product.getPrice().getCurrencyValue()   )
        );
        esProductRepository.save(productDocument);
    }
}
