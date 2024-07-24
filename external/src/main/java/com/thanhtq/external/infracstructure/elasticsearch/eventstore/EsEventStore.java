package com.thanhtq.external.infracstructure.elasticsearch.eventstore;

import com.thanhtq.external.infracstructure.elasticsearch.document.EventDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsEventStore extends ElasticsearchRepository<EventDocument, String> {
}
