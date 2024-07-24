package com.thanhtq.external.infracstructure.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.core.EventStore;
import com.thanhtq.core.domain.product.event.IProductEventHandler;
import com.thanhtq.core.domain.product.event.ProductEvent;
import com.thanhtq.core.domain.product.event.ProductEventType;
import com.thanhtq.external.infracstructure.kafka.EventKafka;
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
public class ProductEventHandler implements IProductEventHandler {
    private final EventStore eventStore;
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
        ProductEvent productEvent  = (ProductEvent) event;
        if (productEvent.getEventType().equals(ProductEventType.CREATED)) {
            created(productEvent);
        }
        eventStore.save(event);
    }

    @Override
    public void handle(List<Event> events) {

    }

    @Override
    public void created(Event event) {
        ProductEvent productEvent = (ProductEvent) event;
        // valida

    }

    @Override
    public void updated(Event event) {
    }

    @Override
    public void delete(Event event) {

    }
}
