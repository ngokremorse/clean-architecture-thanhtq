package com.thanhtq.usecase.model;

import com.thanhtq.domain.product.Money;
import lombok.Data;

@Data
public class ProductModel {
    private String title;
    private String sku;
    private Money price;
}
