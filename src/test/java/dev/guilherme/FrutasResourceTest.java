package dev.guilherme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import javax.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {
    
    @Inject
    FrutasService frutasService;

    @Test
    public void testeListFrutas() {
        given()
          .when()
          .get()
          .then()
             .statusCode(200)
             .body(is("[{\"id\":1,\"nome\":\"Maca\",\"quantidade\":1},{\"id\":2,\"nome\":\"Uva\",\"quantidade\":5},{\"id\":3,\"nome\":\"Pera\",\"quantidade\":16},{\"id\":4,\"nome\":\"Melancia\",\"quantidade\":10},{\"id\":5,\"nome\":\"Abacate\",\"quantidade\":4}]"));
    }
    
    @Test
    public void testeListFrutas2() {
        List<Fruta> list = frutasService.list();
        assertFalse(list.isEmpty());
    }

}