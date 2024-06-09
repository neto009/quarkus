package br.com.test.infraestrutura.api;

import br.com.test.domain.model.PersonModel;
import br.com.test.domain.service.Service;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.List;

@Path("/crud")
@Slf4j
public class Crud {

    @Inject
    Service service;

    @ConfigProperty(name = "parameter.example")
    String propertiesValue;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonModel> findAllPerson() {
        return service.findAllPerson();
    }

    @POST
    @Operation(summary = "Create one person", description = "end point to create one person.")
    @APIResponse(responseCode = "201", description = "Created")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(final PersonModel person) {
        log.info("Criando um novo person: {}", person);
        log.info("Valor resgatado do properties: {}", propertiesValue);
        service.createPerson(person);
    }
}
