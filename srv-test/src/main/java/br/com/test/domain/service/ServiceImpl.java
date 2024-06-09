package br.com.test.domain.service;

import br.com.test.domain.model.PersonModel;
import br.com.test.infraestrutura.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ServiceImpl implements Service {

    @Inject
    PersonRepository personRepository;

    public List<PersonModel> findAllPerson() {
        return personRepository.listAll();
    }

    @Transactional
    public void createPerson(final PersonModel person) {
        personRepository.persist(person);
    }
}
