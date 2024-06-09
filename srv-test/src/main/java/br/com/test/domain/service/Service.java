package br.com.test.domain.service;


import br.com.test.domain.model.PersonModel;

import java.util.List;

public interface Service {

    List<PersonModel> findAllPerson();

    void createPerson(PersonModel person);
}
