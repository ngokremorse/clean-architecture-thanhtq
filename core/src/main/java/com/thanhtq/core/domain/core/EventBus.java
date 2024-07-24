package com.thanhtq.core.domain.core;

public interface EventBus {
    void publishEvent(Event event);
}
