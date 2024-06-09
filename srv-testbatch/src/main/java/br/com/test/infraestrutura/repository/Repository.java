package br.com.test.infraestrutura.repository;

import br.com.test.domain.model.PersonModel;

public interface Repository {
    void save(PersonModel person);
}
