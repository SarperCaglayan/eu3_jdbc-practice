package CybertekApi;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
public class jsonToJavaCollection {

    @BeforeClass
    public void beforeClass(){
        baseURI= "http://api.cybertektraining.com";

    }

    @Test
    public void StudentsToMap(){

        Response response = given().accept(ContentType.JSON).
                pathParam("id", 24107).
                when().get("/student/{id}");

        assertEquals(response.statusCode(),200);

        //convert json response to java map
        Map<String,Object>jsonDataMap= response.body().as(Map.class);

        System.out.println("jsonDataMap = " + jsonDataMap);
        
        String firstName = (String) jsonDataMap.get("students.firstName[0]");

        System.out.println("firstName = " + firstName);
        assertEquals(firstName, "Chara");




    }
}