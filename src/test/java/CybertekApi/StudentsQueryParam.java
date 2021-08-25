package CybertekApi;

import static  io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class StudentsQueryParam {
    /* Given accept type is Json
        When user sends a get request to student/all
        Then response status code is 200
        And response body should be json format
     */
    @Test
    public void QueryParamStudentsTest1() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("studentId","21563")
                .when().get("http://api.cybertektraining.com/student/all");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json;charset=UTF-8");

    }
    @Test
    public void QueryParam2(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("companyName", "Cybertek")
                .queryParam("batch", "14")
                .when().get("http://api.cybertektraining.com/student/all");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");

        assertTrue(response.body().asString().contains("Vera"));

        assertTrue(response.body().asString().contains("F"));


    }
}
