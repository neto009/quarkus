package br.com.test.infraestrutura.rest.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URI;

@ApplicationScoped
public class RestClientFactory {

    public <T> T createClient(Class<T> clazz, String baseUrl) {
        return RestClientBuilder.newBuilder()
                .baseUri(URI.create(baseUrl))
                .build(clazz);
    }
}
