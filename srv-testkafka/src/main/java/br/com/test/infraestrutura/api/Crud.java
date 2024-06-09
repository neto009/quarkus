package br.com.test.infraestrutura.api;

import br.com.test.domain.model.PersonModel;
import br.com.test.infraestrutura.kafka.producer.KafkaProducer;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/kafka")
@Slf4j
public class Crud {

    @Inject
    KafkaProducer kafkaProducer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void produceKafkaPerson() {
        PersonModel personModel = new PersonModel(1L, "NEto", 28);
        log.info("Produzindo: {}", personModel.toString());
        kafkaProducer.send(personModel);
    }
}
