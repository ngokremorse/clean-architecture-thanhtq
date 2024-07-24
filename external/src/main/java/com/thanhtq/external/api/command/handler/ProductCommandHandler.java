package com.thanhtq.external.api.command.handler;

import com.thanhtq.core.domain.core.Command;
import com.thanhtq.core.domain.core.EventBus;
import com.thanhtq.core.domain.product.Product;
import com.thanhtq.core.domain.product.command.IProductCommandHandler;
import com.thanhtq.core.domain.product.event.ProductEvent;
import com.thanhtq.core.domain.product.event.ProductEventType;
import com.thanhtq.external.api.command.ProductCreateCommand;
import com.thanhtq.external.infracstructure.kafka.EventKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCommandHandler implements IProductCommandHandler {
    private final EventBus eventBus;

    @Override
    public void create(Command command) {
        ProductCreateCommand productCreateCommand = (ProductCreateCommand) command;
        ProductEvent productEvent = ProductEvent
                .builder()
                .id(UUID.randomUUID().toString())
                .eventType(ProductEventType.CREATED)
                .product(new Product(
                        productCreateCommand.getTitle(),
                        productCreateCommand.getSku(),
                        productCreateCommand.getPrice()
                ))
                .build();

        EventKafka eventKafka = new EventKafka();
        eventKafka.setEvent(productEvent);
        eventKafka.setKey(productEvent.getProduct().getProductId());
        eventKafka.setTopic("product-topic");

        eventBus.publishEvent(eventKafka);
    }

    @Override
    public void update(Command command) {

    }

    @Override
    public void delete(Command command) {

    }

    @Override
    public void on(Command command) {
        if(command instanceof ProductCreateCommand) {
            create(command);
        }
    }
}
