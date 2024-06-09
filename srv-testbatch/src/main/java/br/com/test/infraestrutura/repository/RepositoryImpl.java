package br.com.test.infraestrutura.repository;

import br.com.test.domain.model.PersonModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
@ApplicationScoped
public class RepositoryImpl implements Repository {

    @Inject
    DataSource dataSource;

    @Override
    public void save(PersonModel person) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO PersonModel (name, age) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, person.getName());
                statement.setInt(2, person.getAge());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}
