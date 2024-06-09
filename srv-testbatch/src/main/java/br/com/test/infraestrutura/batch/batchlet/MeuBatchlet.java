package br.com.test.infraestrutura.batch.batchlet;

import br.com.test.domain.model.PersonModel;
import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.batch.api.chunk.ItemReader;
import jakarta.batch.api.chunk.ItemWriter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Named("meuBatchlet")
@ApplicationScoped
public class MeuBatchlet extends AbstractBatchlet {

    @Inject
    @Named
    private ItemReader itemReader;

    @Inject
    @Named
    private ItemProcessor itemProcessor;

    @Inject
    @Named
    private ItemWriter itemWriter;

    @Override
    public String process() throws Exception {
        runChunk();
        return "COMPLETED";
    }

    public void runChunk() throws Exception {
        Object item = null;
        do {
            item = itemReader.readItem();
            if (item != null) {
                List<PersonModel> chunk = (List<PersonModel>) item;
                try {
                    Object processedChunk = itemProcessor.processItem(chunk);
                    itemWriter.writeItems(List.of(processedChunk));
                } catch (Exception e) {
                    log.error("Error processing chunk", e);
                }
            }
        } while (item != null);
    }
}
