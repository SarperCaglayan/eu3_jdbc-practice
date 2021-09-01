package PetstoreApi;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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
            assertEquals(response.contentType(),"application/json");

            assertTrue(response.body().asString().contains("doggie"));

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
    }

    @Test
    public void QueryParamsMap(){

        Map<String,Object> paramsMap=new HashMap<>();

        paramsMap.put("id","9223372000666033000");
        paramsMap.put("nameContains", "s");

        Response response = given().accept(ContentType.JSON)
                .queryParam(String.valueOf(paramsMap))
                .when().get("/pet/findByStatus?status=available");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");

        assertTrue(response.body().asString().contains("doggie"));

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
    }
}
