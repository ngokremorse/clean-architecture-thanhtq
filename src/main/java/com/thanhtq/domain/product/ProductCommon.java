package com.thanhtq.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductCommon implements Product {
    private String productId;
    private String title;
    private String sku;
    private Money price;

    @Override
    public boolean priceIsValid() {
        assert price.getCurrencyValue() != null;
        return price.getCurrencyCode() != null & price.getCurrencyValue().compareTo(BigDecimal.ZERO) > 0;
    }
}
