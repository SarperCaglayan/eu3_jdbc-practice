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
        /*  Given accept type is Json
            And path param id is 100
            When user send a get request to endpoint
            Then status code is 200
            And Content type is "application/json
            And response payload values match with the followings:
                        id is 100,
                        name is doggie,
                        photoUrls is [String]
                        status is available
         */

    @Test
    public void pathQueryTest1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", "100")
               // .and().pathParam("name","Bela")
                .when().get("/pet/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertTrue(response.body().asString().contains("Carpi"));

        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        System.out.println("Id = " + response.body().path("id").toString());
        System.out.println("photoUrls =" + response.body().path("photoUrls").toString());
        System.out.println("status = " + response.body().path("status"));

        int id= response.body().path( "id");
        String name = response.body().path( "name");
        String status = response.body().path("status");

        assertEquals(id,100);
        assertEquals(name,"doggie");
        assertEquals(status,"available");
    }

    @Test
    public void pathQueryTest2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id","0")
                .when().get("/pet/{id}");

        assertNotEquals(response.statusCode(),200);
        assertEquals(response.statusCode(),404);

        assertTrue(response.body().asString().contains("Pet not found"));

        System.out.println( "response.body().prettyPrint() = " + response.body().prettyPrint());


    }

}
