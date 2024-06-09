package br.com.test.infraestrutura.batch.reader;

import br.com.test.domain.model.PersonModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named("itemReader")
@ApplicationScoped
public class MyItemReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public Object readItem() throws Exception {
        List<PersonModel> currentChunk = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            final PersonModel personModel = this.convertLineInPerson(line);
            currentChunk.add(personModel);
        }
        if(currentChunk.isEmpty()) {
            return null;
        }
        return currentChunk;
    }

    private PersonModel convertLineInPerson(final String line) {
        String[] parts = line.split(";");

        final Long id = Long.valueOf(parts[0]);
        final String name = parts[1];
        final int age = Integer.valueOf(parts[2]);

        return new PersonModel(id, name, age);
    }

    @PostConstruct
    public void init() {
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/registros.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void cleanup() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
