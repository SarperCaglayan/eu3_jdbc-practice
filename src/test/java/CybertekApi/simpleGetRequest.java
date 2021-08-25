package CybertekApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simpleGetRequest {
    String cybertekUrl = "http://api.cybertektraining.com/student/all";

    @Test
    public void test01() {
        Response response = RestAssured.get(cybertekUrl);

        System.out.println("response.statusCode() = " + response.statusCode());
        // System.out.println("response.getBody() = " + response.body().asString());
        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

    }

    /*
    When user send GET request to student/all
    Then status code must be 200
    And body should contains Allen
     */
    @Test
    public void viewStudentsTest2() {

        Response response = RestAssured.get("http://api.cybertektraining.com/student/all");

        // verify status code 200
        Assert.assertEquals(response.statusCode(), 200);

        // verify
        Assert.assertTrue(response.body().asString().contains("Vera"));

    }
    /* Given accept type is Json
        When user sends a get request to student/all
        Then response status code is 200
        And response body should be json format
     */
    @Test (invocationCount = 3)
       public void viewStudentsTest3() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://api.cybertektraining.com/student/all");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json;charset=UTF-8");


    }
}
