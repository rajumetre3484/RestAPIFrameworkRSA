package resources;

//enum is special class in java which has collection of constants or methods
public enum APIResources 
{
	AddPlaceAPI("/maps/api/place/add/json"),  //only methods declaration no body required
	getPlaceAPI("/maps/api/place/get/json"),
	deletPlaceAPI("/maps/api/place/delete/json");
	private String resource;

	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
