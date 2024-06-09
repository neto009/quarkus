package br.com.test.infraestrutura.repository;

import br.com.test.domain.model.PersonModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonModel> {
}
