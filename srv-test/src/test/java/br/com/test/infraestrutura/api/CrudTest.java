package br.com.test.infraestrutura.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class CrudTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/crud")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}