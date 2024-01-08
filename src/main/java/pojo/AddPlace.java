package pojo;

import java.util.List;

public class AddPlace 
{
	// enter values which in json value and using set method there we have to set the keys
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private Location location;    // because its nested Json
	private List<String> types;   // because its array in format
	
	// generate getters and setters so in serilization setters key plays the main role
	// here we well convert the java object into the json type so we have to set the value
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}
