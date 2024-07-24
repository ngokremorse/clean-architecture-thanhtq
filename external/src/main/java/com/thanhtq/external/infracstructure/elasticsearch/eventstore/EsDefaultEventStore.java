package com.thanhtq.external.infracstructure.elasticsearch.eventstore;

import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.core.EventStore;
import com.thanhtq.external.infracstructure.elasticsearch.document.EventDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("esDefaultEventStore")
@RequiredArgsConstructor
public class EsDefaultEventStore implements EventStore {
    private final EsEventStore eventStore;

    @Override
    public void save(Event event) {
        EventDocument eventDocument = new EventDocument();
        eventDocument.setEvent(event);
        eventDocument.setId(UUID.randomUUID().toString());
        eventStore.save(eventDocument);
    }

    @Override
    public void saveAll(List<Event> events) {

    }
}
