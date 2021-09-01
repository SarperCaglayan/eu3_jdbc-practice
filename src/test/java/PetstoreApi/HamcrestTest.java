package PetstoreApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

    @Test
public class HamcrestTest {

        public void MatchersforPet() {
            given().accept(ContentType.JSON)
                    .and().pathParam("id", 7574746)
                    .when().log().all().get("https://petstore.swagger.io/v2/pet/{id}")
                    .then().assertThat().statusCode(200)
                    .and().contentType(equalTo("application/json"))
                    .and().header("Connection", equalTo("keep-alive"))
                    .and().header("Date", notNullValue())
                    .and().assertThat().body("id", equalTo(7574746),
                            "name", equalTo("Hardy"),
                            "status", equalTo("sold"));

        }
        @Test  // this test needs to be repeated runs, then it will pass
        public void MatchersForSoLds(){

            given().when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold")
                    .then().assertThat().statusCode(200)
                    .assertThat().contentType(equalTo("application/json"))
                    .and().assertThat().header("Access-Control-Allow-Methods",equalTo("GET, POST, DELETE, PUT"))
                    .and().header("Connection",equalTo("keep-alive"))
                    .and().assertThat().body("id[0]",equalTo(9223372000666081598L),  //  if test failed use id[0]=7574746
                        "category[0].name", equalTo("culpa cillum fugiat"), // and name= "c'
                            "id[1]",equalTo(10001),     // id[1] = 12
                            "category[1].name", equalTo("c"));  // name= "dog"


        }
        @Test
        public void hasItemsTest(){
            given().get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold")
                    .then().assertThat().statusCode(200)
                    .and().contentType("application/json")
                    .and().header("Transfer-Encoding", equalTo("chunked"))
                            .and().assertThat().body("id", hasItems(9223372000666081598L,33377689,9, 12 ),
                                    "name", hasItems("Hardy", "doggie" ))
                    .log().all();

        }
    }