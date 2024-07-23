package com.thanhtq.external.infracstructure.elasticsearch;

import com.thanhtq.core.domain.product.IProductRepository;
import com.thanhtq.core.domain.product.Product;
import com.thanhtq.external.infracstructure.elasticsearch.document.MoneyObject;
import com.thanhtq.external.infracstructure.elasticsearch.document.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.UUID;

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
        productDocument.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(product, productDocument);

        MoneyObject money = new MoneyObject();
        money.setCurrencyCode(product.getPrice().getCurrencyCode());
        money.setCurrencyValue(product.getPrice().getCurrencyValue());
        productDocument.setPrice(money);
        productDocument.setCreateDate(ZonedDateTime.now());

        esRepository.save(productDocument);
    }
}