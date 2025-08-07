package com.Argela.kafka;

import com.Argela.dataTransferObject.CdrRequest;
import com.Argela.service.CdrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaCdrConsumer {

    private final CdrService cdrService;

    @KafkaListener(topics = "cdr-raw-topic", groupId = "cdr-processor-group", containerFactory = "cdrKafkaListenerFactory")
    public void consume(CdrRequest request) {
        log.info("Data received from Kafka: {}", request);
        cdrService.save(request);
    }
}

