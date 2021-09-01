package PetstoreApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

    @Test
public class HamcrestTest {

        public void MatchersforSold() {
            given().accept(ContentType.JSON)
                    .and().pathParam("id", 7574746)
                    .when().log().all().get("https://petstore.swagger.io/v2/pet/{id}")
                    .then().assertThat().statusCode(200)
                    .and().contentType(equalTo("application/json"))
                    .and().header("Connection", equalTo("keep-alive"))
                    .and().header("Date", notNullValue())
                    .and().assertThat().body("id", equalTo(7574746),
                            "name", equalTo("Hardy"),
                            "status", equalTo("sold"));

        }
    }