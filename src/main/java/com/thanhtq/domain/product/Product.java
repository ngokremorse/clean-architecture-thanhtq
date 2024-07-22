package com.thanhtq.domain.product;

public interface Product {
    String getProductId();
    boolean priceIsValid();
    String getTitle();
    Money getPrice();
    String getSku();
}
