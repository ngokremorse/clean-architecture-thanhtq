package com.thanhtq.external.infracstructure.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyObject {
    private String currencyCode;
    private BigDecimal currencyValue;
}
