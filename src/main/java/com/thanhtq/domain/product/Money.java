package com.thanhtq.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Money {
    private String currencyCode;
    private BigDecimal currencyValue;
}