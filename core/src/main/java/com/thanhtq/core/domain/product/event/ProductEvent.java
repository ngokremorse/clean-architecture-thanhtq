package com.thanhtq.core.domain.product.event;

import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEvent implements Event {

    private String id = UUID.randomUUID().toString();
    private Product product;
    private ProductEventType eventType;
    private final Timestamp createdDate = new Timestamp(System.currentTimeMillis());
}