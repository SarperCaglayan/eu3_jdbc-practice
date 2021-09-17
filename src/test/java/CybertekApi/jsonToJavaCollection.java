package CybertekApi;

import static org.testng.Assert.*;

import com.google.gson.Gson;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class jsonToJavaCollection {

    @BeforeClass
    public void beforeClass(){
        baseURI= "https://api.football-data.org/v2";

    }

    @Test
    public void AreasToListPOJO() {

        Response response = given().accept(ContentType.JSON).
                pathParam("id", 2000).
                when().get("/areas/{id}");

        assertEquals(response.statusCode(), 200);

        response.prettyPrint();

        AreasOfFootball areas1= response.body().as(AreasOfFootball.class);

        System.out.println("areas1.toString() = " + areas1.toString());

        assertEquals(areas1.getId(),2000);
        assertEquals(areas1.getName(),"Afghanistan");
        assertEquals(areas1.getCountryCode(),"AFG");
        assertEquals(areas1.getParentArea(),"Asia");
        assertEquals(areas1.getEnsignUrl(),null);
        assertEquals(areas1.getParentAreaId(),2014);




    }
    @Test
    public void GsonForAreas(){

        String myJsonBody="{\n" +
                "    \"id\": 2247,\n" +
                "    \"name\": \"Turkey\",\n" +
                "    \"countryCode\": \"TUR\",\n" +
                "    \"ensignUrl\": \"https://upload.wikimedia.org/wikipedia/commons/b/b4/Flag_of_Turkey.svg\",\n" +
                "    \"parentAreaId\": 2077,\n" +
                "    \"parentArea\": \"Europe\",\n" +
                "    \"childAreas\": []\n" +
                "}";

        Gson gsonArea = new Gson();
        AreasOfFootball areasData= gsonArea.fromJson(myJsonBody,AreasOfFootball.class);  //deserialization

        System.out.println("FootballData of Turkey = " + areasData.toString());

        assertEquals(areasData.getId(),2247);
        assertEquals(areasData.getName(),"Turkey");


        AreasOfFootball areas= new AreasOfFootball(2222,"Bangladesh","BAN", null, 2077, "Asia" );

        String jsonBody= gsonArea.toJson(areas);  //serialization
        System.out.println("FootballData of Bangladesh = " + jsonBody);

    }}