package Homework;


import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.List;
import static io.restassured.RestAssured.baseURI;

public class homework1 {
/*
    ORDS API:
    Q1:
- Given accept type is Json
- Path param value- US
- When users sends request to /countries
- Then status code is 200
- And Content - Type is Json
- And country_id is US
- And Country_name is United States of America
- And Region_id is
 */
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("value", "US")
                .when().get("/countries");

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(response.contentType(),"application/json");
   // Assert.assertEquals(response.);

    }}
