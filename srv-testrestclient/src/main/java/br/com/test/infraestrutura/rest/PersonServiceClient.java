package br.com.test.infraestrutura.rest;

import br.com.test.domain.model.PersonModel;

import java.util.List;


public interface PersonServiceClient {
    List<PersonModel> getAllPerson(final String baseUrl);
}
