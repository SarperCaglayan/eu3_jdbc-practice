package CybertekApi;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetstoreTestsWithQueryParams {

    @BeforeClass
    public void PetStoreBaseUrl(){

        baseURI= "https://petstore.swagger.io/v2";
    }

    @Test
    public void petStoreQueryParamTest1(){

            Response response = given().accept(ContentType.JSON)
                    .queryParam("id", "9223372000666033000")
                    .when().get("/pet/findByStatus?status=available");

            assertEquals(response.statusCode(),200);
            assertTrue(response.contentType(),"application/json");


        }
}
