package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils 
{
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecifiaction() throws IOException
	
	{
		if(req==null) // using this below blocks to avoid to run everytimes because in logs overlaping happens
		{
	        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));// adding response output and to writing so used fileOutputStream
	
     req = new RequestSpecBuilder()
    		                     .setBaseUri(getGlobalValue("baseurl")) // geting baseuri from below class
                                 .addQueryParam("key", "qaclick123")
                                 .addFilter(RequestLoggingFilter.logRequestTo(log)) //printing response output
                                 .addFilter(ResponseLoggingFilter.logResponseTo(log))// above and this both used to reduces request and resoponse specification redues
                                 .setContentType(ContentType.JSON) // set key
                                 .build();
     return req;
		}
		
      return req; // we wants seperate logs in multiple data sets
				                                         
	}
	
	public static String getGlobalValue(String key) throws IOException // getting url from properties file and get any VALUE from propertie file using KEY made generic
	{
		Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\APIFramework_FromScratch_RSA\\src\\test\\java\\resources\\global.properties");  // reading file used FileInputStream
		 prop.load(fis);
		return prop.getProperty(key); // sending the key so returns only this
		 
	}
	
	public String getJsonPath(Response response, String key)
	{
		String resp = response.asString();
		 JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
				
	}

}
