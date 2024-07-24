package com.thanhtq.external.infracstructure.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.core.EventBus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventBusKafka implements EventBus {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void publishEvent(Event event) {
        EventKafka eventKafka = (EventKafka)event;
        try {
            publishEvent(eventKafka.getTopic(), eventKafka.getKey(), eventKafka.getEvent());
        } catch (JsonProcessingException e) {
            log.error("Error: {0}", e);
        }
    }

    private void publishEvent(String topic, String key, Object data) throws JsonProcessingException {
        kafkaTemplate.send(topic, key, objectMapper.writeValueAsString(data));
    }
}
