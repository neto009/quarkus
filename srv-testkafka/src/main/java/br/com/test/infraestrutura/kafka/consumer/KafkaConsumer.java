package br.com.test.infraestrutura.kafka.consumer;

import br.com.test.domain.model.PersonModel;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
@Slf4j
public class KafkaConsumer {

    @Incoming("topic-test")
    public void consume(final ConsumerRecord<String, PersonModel> record) {
        log.info("Received person: {}", record.value().toString());
    }
}