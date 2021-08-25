package CybertekApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PetstoreWithJsonPathMethod {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";

    }

    @Test
    public void TestWithJsonPath(){

        Response response = RestAssured.get("/pet/findByStatus?status=available");
        // System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        JsonPath JsonData= response.jsonPath();

        System.out.println("JsonData.getList(\"id\") = " + JsonData.getList("id"));
        System.out.println("JsonData.getList(\"id\") = " + JsonData.getList("id").size());
        System.out.println("JsonData.getString(\"name\") = " + JsonData.getString("name"));

        System.out.println("First pet name " + JsonData.getString("name[0]"));
        System.out.println("Last pet name = " + JsonData.getString("name[-1]"));

        int id1= JsonData.getInt("id[0]");
        String name=JsonData.getString("name[0]");
        String photoUrls = JsonData.getString("photoUrls[0]");

        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("photoUrls= " + photoUrls);

      /*
            assertEquals(id1,25921110);
            assertEquals(name,"pussyCat");
            assertEquals(photoUrls,"string");
        (id, name and photoUrls are not static)   */

    }
}
