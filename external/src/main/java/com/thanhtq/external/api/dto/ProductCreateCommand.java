package com.thanhtq.external.api.dto;

import com.thanhtq.core.domain.core.Command;
import com.thanhtq.core.domain.product.Money;
import lombok.Data;

@Data
public class ProductCreateCommand implements Command {

    private String title;
    private String sku;
    private Money price;
}
