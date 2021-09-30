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

public class StudentsDeserialize {

    @Test
    public void studentDeserialization(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/24107");

    //    response.prettyPrint();

        Map<String,Object> jsonDataMap= response.body().as(Map.class);

        System.out.println("jsonDataMap = " + jsonDataMap);

        System.out.println("jsonDataMap.get(\"students\") = " + jsonDataMap.get("students"));

        List<Map<String,Object>> studentList=(List<Map<String,Object>>) jsonDataMap.get("students");

        System.out.println("Student's name = " + studentList.get(0).get("firstName")); //print firstName= Chara

        //Nested Map
        //Outer Map
        Map<String,Map<String,String>> mapCompany= (Map<String,Map<String,String>>)studentList.get(0).get("company");
        System.out.println("mapCompany.get(\"companyName\") = " + mapCompany.get("companyName"));

        //Inner Map
        Map<String, String> address = mapCompany.get("address");
        System.out.println("address = " + address);
        Assert.assertEquals(address.get("state"), "Pennsylvania");


    }

}
