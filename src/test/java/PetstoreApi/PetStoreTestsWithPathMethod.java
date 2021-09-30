package PetstoreApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PetStoreTestsWithPathMethod {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";
}
    @Test
    public void PathMethodforPetstore(){

        Response response = RestAssured.get("pet/findByStatus?status=sold");
        System.out.println("response.body().prettyPrint() = " + response.body().prettyPrint());

        int firstId= response.path("id[0]");
        System.out.println("firstId = " + firstId);
        int lastId=response.path("id[-1]");
        System.out.println("lastId = " + lastId);
        List<Object> listOfIds= response.path("id");
        System.out.println("listOfIds = " + listOfIds);
        System.out.println("listOfIds.size() = " + listOfIds.size()); //number of sold dogs
        System.out.println("listOfIds.indexOf(1991) = " + listOfIds.indexOf(1991));

        List<String> namesOfSoldPets= response.path("name");
        System.out.println("namesOfSoldPets = " + namesOfSoldPets);
        Set<Object> onlyNames= new HashSet<>(namesOfSoldPets);
        System.out.println("onlyNames = " + onlyNames);

        int count=0;
        System.out.println("Sold pets :");
        for( Object petNames : onlyNames){
            count++;
            System.out.println( count + ")" + petNames);

        }

    }}
