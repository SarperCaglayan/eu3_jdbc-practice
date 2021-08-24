package CybertekApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetstoreTestsWithPathParameters {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI= "https://petstore.swagger.io/v2";
    }


    @Test
    public void pathTest1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", "93678")
               // .and().pathParam("name","Bela")
                .when().get("/pet/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertTrue(response.body().asString().contains("Bela"));

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());


    }

    @Test
    public void pathTest2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id","0")
                .when().get("/pet/{id}");

        assertNotEquals(response.statusCode(),200);
        assertEquals(response.statusCode(),404);

        assertTrue(response.body().asString().contains("Pet not found"));

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());
    }
}
