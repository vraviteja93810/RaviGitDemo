package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
@Before("@Deleteplace ")
public void beforeScenario() throws IOException
{
	//execute this code only when place id is null.
	StepDefinition s=new StepDefinition();
	if(StepDefinition.place_id==null)
	{
	//Write a code that will give you place id.
	
	s.add_place_payload_with("Raviteja", "1-400-1", "English");
	s.user_calls_with_http_request("AddPlaceAPI", "POST");
	s.verify_place_id_created_maps_to_using("Raviteja", "getPlaceAPI");
	}
}
}