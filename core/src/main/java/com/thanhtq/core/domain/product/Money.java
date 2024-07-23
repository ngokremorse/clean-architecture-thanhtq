package com.thanhtq.core.domain.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Money {
    private String currencyCode;
    private BigDecimal currencyValue;

    public Money(String currencyCode, BigDecimal currencyValue) {
        setCurrencyCode(currencyCode);
        setCurrencyValue(currencyValue);
    }

    public void setCurrencyCode(String currencyCode) {
        if(currencyCode == null || currencyCode.equals("")) {
            throw new IllegalArgumentException("Currency code is required");
        }
        this.currencyCode = currencyCode;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        if(currencyValue == null || currencyValue.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Currency value is not less 0");
        }
        this.currencyValue = currencyValue;
    }
}