package br.com.test.infraestrutura.api;

import br.com.test.infraestrutura.batch.Batch;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Path("/batch")
@Slf4j
public class Crud {

    @Inject
    Batch batch;

    @GET
    public void produceKafkaPerson() {
        batch.execute();
    }
}
