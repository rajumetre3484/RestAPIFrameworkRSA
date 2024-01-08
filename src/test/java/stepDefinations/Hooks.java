package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{
	@Before("@DeletePlace")
	public void beforeSCenario() throws IOException
	{
		//write a code that will give you place id
		//execute this code only when place id is null
		
		StepDefinitionDynamicValue m = new StepDefinitionDynamicValue();
		
		if(StepDefinitionDynamicValue.place_id==null)
		{
		m.add_place_payload_with("Shetty", "French", "Asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
	}
	}
}
