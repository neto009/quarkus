package br.com.test.infraestrutura.rest;

import br.com.test.domain.model.PersonModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/crud")
@RegisterRestClient(configKey="person-api")
public interface PersonRestCall {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<PersonModel> getAllPerson();
}
