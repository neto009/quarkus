package br.com.test.infraestrutura.kafka.producer;

import br.com.test.domain.model.PersonModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
public class KafkaProducer {

    @Inject
    @Channel("kafka-producer-channel")
    Emitter<ProducerRecord<String, PersonModel>> emitter;

    public void send(final PersonModel person) {
        ProducerRecord<String, PersonModel> record = new ProducerRecord<>("topic-test", UUID.randomUUID().toString(), person);
        emitter.send(record);
    }
}
