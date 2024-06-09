package br.com.test.infraestrutura.api;

import br.com.test.domain.model.PersonModel;
import br.com.test.infraestrutura.rest.PersonServiceClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Path("/person")
@Slf4j
public class Crud {

    @ConfigProperty(name = "parameter.example")
    String urlFromProperties;

    @Inject
    PersonServiceClient personServiceClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonModel> findAllPerson() {
        return personServiceClient.getAllPerson(urlFromProperties);
    }
}
