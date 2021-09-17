package CybertekApi;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class StudentsPojo {

    @Test
    public void studentDeser(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/24107");

    //    response.prettyPrint();

        Map<String,Object> jsonDataMap= response.body().as(Map.class);

        System.out.println("jsonDataMap = " + jsonDataMap);


        System.out.println("jsonDataMap.get(\"students\") = " + jsonDataMap.get("students"));

        List<Map<String,Object>> studentList=(List<Map<String,Object>>) jsonDataMap.get("students");

        System.out.println("Student's name = " + studentList.get(0).get("firstName")); //print firstName= Chara

        System.out.println("studentList.get(0) = " + studentList.get(0).get("company.address"));

        //Assert.assertEquals(studentList.get(0).get("company.address.state"), "Pennsylvania");
    }

}
