package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuildForGettingDanamicValue 
{
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace p = new AddPlace(); // here value to be set and then ref var p pass to the body
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(address);
		p.setLanguage(language);
		p.setWebsite("http://google.com");

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList); // because its array so created araylist and add the values above

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l); // Location is class so created object of Location class and using ref var we
							// add the values in its class above shown
        return p;
	}
	
	public String deletePlacePayload(String place_id)
	{
		return "{\r\n \"place_id\":\""+place_id+"\"\r\n}";
	}

}
