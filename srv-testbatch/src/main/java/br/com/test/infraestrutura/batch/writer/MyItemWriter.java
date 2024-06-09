package br.com.test.infraestrutura.batch.writer;

import br.com.test.domain.model.PersonModel;
import br.com.test.infraestrutura.repository.Repository;
import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Named("itemWriter")
@ApplicationScoped
public class MyItemWriter extends AbstractItemWriter {

    @Inject
    Repository repository;

    @Override
    public void writeItems(List<Object> list) {
        log.info("Writing {} items", list.size());
        List<PersonModel> personModelList = (List)list.get(0);
        personModelList.forEach(item -> {
            log.info("Item: {}", item.toString());
            repository.save(item);
        });
    }
}
