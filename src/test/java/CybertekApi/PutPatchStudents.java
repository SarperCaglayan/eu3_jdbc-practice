package CybertekApi;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchStudents {

    @BeforeClass
    public void beforeClass(){
        baseURI= "http://api.cybertektraining.com";

    }
    @Test
    public void putStudent(){
/*
        Map<String,Object> mapOfStu= new HashMap<>();
        mapOfStu.put("firstName", "Mualla");
        mapOfStu.put("lastName", "İşarar");
        mapOfStu.put("gender", "Female");
        mapOfStu.put("batch","5");
        mapOfStu.put("joinDate", "05/16/2020");
        mapOfStu.put()
  */

        given().log().all()
                .and().contentType(ContentType.JSON)
                .and()
                .queryParam("id", 10423)
                .and()
                .body("{    \"teacherId\": 10423,\n" +
                        "    \"firstName\": \"Alexander\",\n" +
                        "    \"lastName\": \"Syrup\",\n" +
                        "    \"emailAddress\": \"alexander@email.com\",\n" +
                        "    \"joinDate\": \"05/16/2020\",\n" +
                        "    \"password\": \"12345\",\n" +
                        "    \"phone\": \"12345689\",\n" +
                        "    \"subject\": \"Test\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"department\": \"Computer\",\n" +
                        "    \"birthDate\": \"05/11/2001\",\n" +
                        "    \"salary\": 3000,\n" +
                        "    \"batch\": 5,\n" +
                        "    \"section\": \"IT\",\n" +
                        "    \"premanentAddress\": \"Paris\"")
                .when()
                .put("/teacher/update")
                .then().log().all()
                .assertThat().statusCode(200);

    }


}
