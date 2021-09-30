package apitests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class Bookit_Auth {

    String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1NyIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.a_N9URDBPGOMcDdEVoaMHsJtk3jOnig0v0SCtSWcsGE";
    @BeforeClass
    public void setup(){

        baseURI= "https://cybertek-reservation-api-qa2.herokuapp.com";
    }

    @Test

    public void test1(){
        Response response = given().header("Authorization", accessToken)
                .when().get("/api/campuses");


        assertEquals(response.statusCode(),200);
        response.prettyPrint();
        assertTrue(response.body().asString().contains("harvard"));

    }
}
