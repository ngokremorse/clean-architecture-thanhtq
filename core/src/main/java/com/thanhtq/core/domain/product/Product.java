package com.thanhtq.core.domain.product;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private final String productId;
    private final String title;
    private final String sku;
    private final Money price;

    public Product(String title, String sku, Money price) {
        this.productId = UUID.randomUUID().toString();
        this.title = title;
        this.sku = sku;
        this.price = price;
    }

}
