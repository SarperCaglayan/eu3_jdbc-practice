package CybertekApi;

import static  io.restassured.RestAssured.*;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import utilities.ConfigurationReader;

public class TestWithJsonPath {

    @BeforeClass
    public void beforeClass(){

        baseURI = "http://api.cybertektraining.com";
    }
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 21603)
                .when().get("/student/{id}");

        //verify status code
        assertEquals(response.statusCode(),200);

        //assign response to jsonpath
        JsonPath jsonPath = response.jsonPath();

        //get values from jsonpath
        String firstName = jsonPath.getString("students.firstName[0]");
        System.out.println("firstName = " + firstName);

        String lastName = jsonPath.get("students.lastName[0]");
        System.out.println("lastName = " + lastName);

        String phone = jsonPath.getString("students.contact[0].phone");
        System.out.println("phone = " + phone);

        String cityOfVera = jsonPath.getString("students.company[0].address.city");
        System.out.println("CityOfVera = " + cityOfVera);
        assertEquals(cityOfVera,"Chicago");

    }
}
