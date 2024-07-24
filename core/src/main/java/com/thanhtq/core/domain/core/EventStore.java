package com.thanhtq.core.domain.core;

import java.util.List;

public interface EventStore {
    void save(Event event);
    void saveAll(List<Event> events);
}
