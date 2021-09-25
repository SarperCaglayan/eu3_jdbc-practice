package CybertekApi.PojoCyberStudents;

import static io.restassured.RestAssured.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class Pojo_Students {
        @BeforeClass
        public void beforeClass() {

            baseURI = "http://api.cybertektraining.com";
        }

        @Test
        public void onePojo_Student() {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", "21563")
                .when().get("/student/{id}");

                assertEquals(response.statusCode(), 200);
                System.out.println("response.prettyPrint() = " + response.prettyPrint());
                // JSON to POJO ---> Deserialize to java custom class
                // JSON to our Students class object

                CyberStudents studentX= response.body().as(CyberStudents.class);
                List<Student> studentTrolololo = studentX.getStudents();

                System.out.println("student StudentId = " + studentTrolololo.get(0).getStudentId());
                System.out.println("student Batch = " + studentTrolololo.get(0).getBatch());
                System.out.println("student CompanyId = " + studentTrolololo.get(0).getCompany().getCompanyId());
                System.out.println("student City() = " + studentTrolololo.get(0).getCompany().getAddress().getCity());


        }
        @Test
        public void gson_example(){
                Gson gson= new Gson();

               String myJsonData= "{\n" +
                       "            \"studentId\": 21563,\n" +
                       "            \"firstName\": \"trolololo\",\n" +
                       "            \"lastName\": \"iokmakariok\",\n" +
                       "            \"batch\": 15,\n" +
                       "            \"joinDate\": \"11/11/1990\",\n" +
                       "            \"birthDate\": \"12/23/2010\"}";

                Map<String,Object> map= gson.fromJson(myJsonData, Map.class);
                System.out.println("map = " + map);

                CyberStudents students= gson.fromJson(myJsonData, CyberStudents.class);
                List<Student> studentList = students.getStudents();
           // System.out.println("studentList.get(0).getFirstName() = " + studentList.get(0).getFirstName());
        }

}
