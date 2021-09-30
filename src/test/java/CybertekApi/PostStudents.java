package CybertekApi;
import static org.testng.Assert.*;

import CybertekApi.PojoCyberStudents.Address;
import CybertekApi.PojoCyberStudents.Company;
import CybertekApi.PojoCyberStudents.Contact;
import CybertekApi.PojoCyberStudents.Student;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostStudents {

    @BeforeClass
    public void beforeClass(){
        baseURI= "http://api.cybertektraining.com/";

    }
    @Test
    public void postMethod(){
        Response response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).
                body(" {\n" +
                        "  \"admissionNo\": \"9876543\",\n" +
                        "  \"batch\": 15,\n" +
                        "  \"birthDate\": \"11/01/1977\",\n" +
                        "  \"company\": {\n" +
                        "    \"address\": {\n" +
                        "      \"addressId\": 0,\n" +
                        "      \"city\": \"string\",\n" +
                        "      \"state\": \"string\",\n" +
                        "      \"street\": \"string\",\n" +
                        "      \"zipCode\": 0\n" +
                        "    },\n" +
                        "    \"companyId\": 0,\n" +
                        "    \"companyName\": \"string\",\n" +
                        "    \"startDate\": \"string\",\n" +
                        "    \"title\": \"string\"\n" +
                        "  },\n" +
                        "  \"contact\": {\n" +
                        "    \"contactId\": 0,\n" +
                        "    \"emailAddress\": \"colybaly@colybalyfamily.com\",\n" +
                        "    \"phone\": 1234123456,\n" +
                        "    \"premanentAddress\": \"string\"\n" +
                        "  },\n" +
                        "  \"firstName\": \"Clara\",\n" +
                        "  \"gender\": \"Female\",\n" +
                        "  \"joinDate\": \"21/09/2020\",\n" +
                        "  \"lastName\": \"Colybaly\",\n" +
                        "  \"major\": \"IT\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"section\": \"string\",\n" +
                        "  \"studentId\": 0,\n" +
                        "  \"subject\": \"string\"\n" +
                        "}").
                when().post("student/create");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json;charset=UTF-8");

        assertEquals(response.path("firstName"), "Clara");

        //assertion with JsonPath
        JsonPath jsonbody= response.jsonPath();
        assertEquals(jsonbody.getString("lastName"), "Colybaly");
        assertEquals(jsonbody.getLong("contact.phone"),1234123456 );
        assertEquals(jsonbody.getString("contact.emailAddress"), "colybaly@colybalyfamily.com");

        // after post request, I sent a get request by using dynamic id(studenttId) with queryparam
        int id= response.path("studentId");

        given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("student/{id}")
                .then().statusCode(200)
                .and().contentType("application/json").log().all();



    }

    @Test
    public void postMethodWithMap(){

        HashMap<String, Object> jsonMap= new HashMap<String,Object>();
        jsonMap.put("firstName", "ClaraMap");
        jsonMap.put("lastName", "ColybalyMap");
        jsonMap.put("batch", 15);
        jsonMap.put("joinDate", "11/11/1990");
        jsonMap.put("birthDate", "12/23/2010");
        jsonMap.put("password", "string");
        jsonMap.put("subject", "string");
        jsonMap.put("gender", "string");
        jsonMap.put("admissionNo", "123");
        jsonMap.put("major", "string");
        jsonMap.put("section", "string");

        ArrayList<Map<String,Object>> studentsList= new ArrayList<>();

        //jsonMap.put("students", studentsList);
        studentsList.add(jsonMap);
        HashMap<String, Object> companyMap= new HashMap<String,Object>();
        jsonMap.put("company",companyMap);
        //companyMap.put("companyId", 1234);
        companyMap.put("companyName", "SYS");
        companyMap.put("title", "SDET");
        companyMap.put("startDate", "today");

        HashMap<String, Object> addressMap= new HashMap<String,Object>();
        companyMap.put("address", addressMap);
        addressMap.put("city","Tysons");
        addressMap.put("state","VA");
        addressMap.put("zipCode",1);
        addressMap.put("street","Main Boulevard");

        HashMap<String, Object> contactMap= new HashMap<String,Object>();
        jsonMap.put("contact", contactMap);
        contactMap.put("phone", "1234233333");
        contactMap.put("emailAddress", "email@emailaddress.com");
        contactMap.put("premanentAddress", "lobby");

        System.out.println(studentsList.toString());

        given().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .and().body(jsonMap)
        .when().post("student/create")
                .then().
                statusCode(200).
                and().contentType(ContentType.JSON);
        //       System.out.println("response.prettyPrint() = " + response.prettyPrint());
    }

    @Test
    public void chainPost(){

        given().accept(ContentType.JSON).and().contentType(ContentType.JSON).
                body(" {\n" +
                        "  \"admissionNo\": \"9876543\",\n" +
                        "  \"batch\": 15,\n" +
                        "  \"birthDate\": \"11/01/1977\",\n" +
                        "  \"company\": {\n" +
                        "    \"address\": {\n" +
                        "      \"addressId\": 0,\n" +
                        "      \"city\": \"string\",\n" +
                        "      \"state\": \"string\",\n" +
                        "      \"street\": \"string\",\n" +
                        "      \"zipCode\": 0\n" +
                        "    },\n" +
                        "    \"companyId\": 0,\n" +
                        "    \"companyName\": \"string\",\n" +
                        "    \"startDate\": \"string\",\n" +
                        "    \"title\": \"string\"\n" +
                        "  },\n" +
                        "  \"contact\": {\n" +
                        "    \"contactId\": 0,\n" +
                        "    \"emailAddress\": \"colybaly@colybalyfamily.com\",\n" +
                        "    \"phone\": 1234123456,\n" +
                        "    \"premanentAddress\": \"string\"\n" +
                        "  },\n" +
                        "  \"firstName\": \"Clara\",\n" +
                        "  \"gender\": \"Female\",\n" +
                        "  \"joinDate\": \"21/09/2020\",\n" +
                        "  \"lastName\": \"Colybaly\",\n" +
                        "  \"major\": \"IT\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"section\": \"string\",\n" +
                        "  \"studentId\": 0,\n" +
                        "  \"subject\": \"string\"\n" +
                        "}").
                when().post("student/create").
                then().log().all().
                        statusCode(200)
                .and().contentType(ContentType.JSON).
                body("firstName", is("Clara"),
                        "lastName",equalTo( "Colybaly"),
                        "gender", equalTo("Female"),
                        "contact.emailAddress", equalTo("colybaly@colybalyfamily.com"));

    }

    @Test
    public void PostwithPOJO(){

        Student studentX= new Student();

        studentX.setFirstName("ClaraPojo");
        studentX.setLastName("Coly");
        studentX.setBirthDate("12/12/1977");
        studentX.setGender("Female");
        studentX.setBatch(15);
        studentX.setJoinDate("12/09/2021");
        studentX.setPassword("12345");
        studentX.setSubject(" ");
        studentX.setAdmissionNo("123456");
        studentX.setMajor("major");
        studentX.setSection("string");

        Company company= new Company();
        studentX.setCompany(company);

        //company.setCompanyId(12345);
        company.setCompanyName("SYS");
        company.setTitle("title");
        company.setStartDate(" ");

        Address address= new Address();
        company.setAddress(address);
        address.setCity("Tysons");
        address.setState("VA");
        address.setZipCode(1);
        address.setStreet("Main Boulevard");

        Contact contact=new Contact();
        studentX.setContact(contact);
        contact.setPhone("1234233333");
        contact.setEmailAddress("email@emailaddress.com");
        contact.setPremanentAddress("lobby");



        given().log().all().accept(ContentType.JSON).and().contentType(ContentType.JSON)
                .and()
                        .body(studentX)
                .when().log().all()
                        .post("student/create")
                .then()
                        .statusCode(200)
                .and()
                        .contentType(ContentType.JSON)
                .and()
                        .body("firstName", equalTo("ClaraPojo"),
                        "lastName", equalTo("Coly"),
                        "batch", equalTo( 15));



    }

}
