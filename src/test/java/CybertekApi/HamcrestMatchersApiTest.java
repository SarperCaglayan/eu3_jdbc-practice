package CybertekApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class HamcrestMatchersApiTest {
/*
      given accept type is Json
      And path param id is 10423
      When user sends a get request to spartans/{id}
      Then status code is 200
      And content type is Json
      And json data has following
          "id": 10423,
          "firstName": "Alexander",
          "lastName": "Syrup",
          "gender": "Male",
          "phone": 12345689


    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "http://api.cybertektraining.com";
    }
        */


    @Test
    public void OneStudentWithHamcrest(){

        given().accept(ContentType.JSON)
                .and().pathParam("id",10423)
                .when().log().all().get("http://api.cybertektraining.com/teacher/{id}")
                .then().assertThat().statusCode(200)
                .and().contentType(equalTo("application/json;charset=UTF-8"))
                .and().header("Content-Length",equalTo("236"))
                .and().header("Connection",equalTo("Keep-Alive"))
                .and().header("Date",notNullValue())
                .and().assertThat().body("teachers.firstName[0]",equalTo("Alexander"),
                        "teachers.lastName[0]",equalTo("Syrup"),
                        "teachers.gender[0]",equalTo("male"),
                        "teachers.phone[0]",equalTo("12345689"))
                .log().all()
        ;


    }
    @Test
    public void teacherWithDepartment(){
        given().accept(ContentType.JSON)
                .and().pathParam("name","Technology")
                .when().log().all().get("http://api.cybertektraining.com/teacher/department/{name}")
                .then().assertThat().statusCode(200)
                .and().contentType(equalTo("application/json;charset=UTF-8"))
                .and().body("teachers.firstName", hasItems("William", "Gary", "Delaine")).
                log().all()

        ;

    }
}
