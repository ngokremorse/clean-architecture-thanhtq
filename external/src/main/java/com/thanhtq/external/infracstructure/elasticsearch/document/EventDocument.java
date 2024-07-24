package com.thanhtq.external.infracstructure.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thanhtq.core.domain.core.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(dynamic = Dynamic.TRUE, indexName = "product-event-index")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDocument {
    private String id;
    private Event event;
}
