package com.thanhtq.external.infracstructure.kafka;

import com.thanhtq.core.domain.core.Event;
import lombok.Data;

import java.util.UUID;

@Data
public class EventKafka implements Event {
    private String topic;
    private String key;
    private String id = UUID.randomUUID().toString();
    private Event event;
}
