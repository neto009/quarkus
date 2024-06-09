package br.com.test.infraestrutura.batch.processor;

import br.com.test.domain.model.PersonModel;
import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named("itemProcessor")
@ApplicationScoped
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        final List<PersonModel> personModelList = (List) item;
        final List<PersonModel> currentPersonList = personModelList.stream()
                .map(person -> {
                    person.setName("Neto");
                    return person;
                }).collect(Collectors.toList());
        return currentPersonList;
    }
}