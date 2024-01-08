package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild 
{
	public AddPlace addPlacePayLoad()
	{
		AddPlace p = new AddPlace(); // here value to be set and then ref var p pass to the body
		p.setAccuracy(50);
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
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

}
