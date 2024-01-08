package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.TestDataBuildForGettingDanamicValue;
import resources.Utils;

public class StepDefinitionDynamicValue extends Utils
{
	RequestSpecification res;
	ResponseSpecification respspec;
	Response response;
	TestDataBuildForGettingDanamicValue	 dataDynamic = new TestDataBuildForGettingDanamicValue();
	static String place_id ;
	

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException 
	{
		
            res = given().spec(requestSpecifiaction()) // all reqest common points store and provided here using spec
													// builder
			             .body(dataDynamic.addPlacePayLoad(name,language,address)); // return type RequestSpecification ending here ; only

	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method)
	{
		//constructor will be called with value of resource which you pass
		 APIResources resourceAPI = APIResources.valueOf(resource);  // getting from enum
		System.out.println( resourceAPI.getResource());
		
		  respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();// extra added because remove the requestspec line
		  
		  if(method.equalsIgnoreCase("POST"))
		  response = res.when()
	                         .post(resourceAPI.getResource());    //.post("/maps/api/place/add/json")
	                         else if(method.equalsIgnoreCase("GET"))
	                        	response = res.when().get(resourceAPI.getResource());
	                   /* .then(
	                         .spec(respspec).extract().response(); */

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) 
	{
        Assert.assertEquals(response .getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) 
	{
	/*String resp = response.asString(); // moved to utile class
	 js = new JsonPath(resp);
	Assert.assertEquals(js.get(keyValue).toString(), Expectedvalue); */
	
	Assert.assertEquals(getJsonPath(response, keyValue), Expectedvalue); 

	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException
	{
		//reqestSpec
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecifiaction()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name");
		Assert.assertEquals(actualName,expectedName);    
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException
	{
	 res = given().spec(requestSpecifiaction()).body(dataDynamic.deletePlacePayload(place_id));
	  
	}
	
}
