package com.thanhtq.external.infracstructure.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.core.EventHandler;
import com.thanhtq.core.domain.product.event.ProductEvent;
import com.thanhtq.core.domain.product.event.ProductEventType;
import com.thanhtq.core.domain.product.service.ICreateProductService;
import com.thanhtq.core.domain.product.service.IUpdateProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductEventHandler implements EventHandler {
    private final ICreateProductService createProductService;
    private final IUpdateProductService updateProductService;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "product-topic",
            groupId = "product-group",
            concurrency = "1"
    )
    public void listener(@Payload String event, Acknowledgment acknowledgment) throws JsonProcessingException {
        ProductEvent productEvent = objectMapper.readValue(event, ProductEvent.class);
        handle(productEvent);
        acknowledgment.acknowledge();
    }

    @Override
    public void handle(Event event) {
        ProductEvent productEvent = (ProductEvent) event;
        if (productEvent.getEventType().equals(ProductEventType.CREATED)) {
            createProductService.createProduct((ProductEvent) event);
        } else if (productEvent.getEventType().equals(ProductEventType.UPDATED)) {
            updateProductService.updateProductService((ProductEvent) event);
        }
    }

    @Override
    public void handle(List<Event> events) {

    }
}
