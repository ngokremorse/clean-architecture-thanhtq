package com.thanhtq.core.domain.core;

import java.util.List;

public interface EventHandler {

    void handle(List<Event> events);
    void handle(Event event);
}
