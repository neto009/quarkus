package br.com.test.infraestrutura.rest;

import br.com.test.domain.model.PersonModel;
import br.com.test.infraestrutura.rest.config.RestClientFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonServiceClientImpl implements PersonServiceClient {

    @Inject
    RestClientFactory restClientFactory;

    public List<PersonModel> getAllPerson(final String baseUrl) {
        PersonRestCall personRestCall = restClientFactory.createClient(PersonRestCall.class, baseUrl);
        return personRestCall.getAllPerson();
    }
}
