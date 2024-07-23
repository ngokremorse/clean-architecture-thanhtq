package com.thanhtq.core.usecase.model;

import com.thanhtq.core.domain.product.Money;
import lombok.Data;

@Data
public class ProductModel {
    private String title;
    private String sku;
    private Money price;
}
