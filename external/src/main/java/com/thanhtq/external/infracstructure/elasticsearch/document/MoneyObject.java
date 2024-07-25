package com.thanhtq.external.infracstructure.elasticsearch.document;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyObject {
    private String currencyCode;
    private BigDecimal currencyValue;
}
