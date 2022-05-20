import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserDetails {

    //use the below variable declarations
	public static WebDriver driver;
	public static JSONArray details;
	
	public static WebDriver createDriver() {    //Do not change the class name
		/* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'http://webapps.tekstac.com/FormRegistration/UserRegistration.html'  */
		
		driver = DriverSetup.getWebDriver();
		
		driver.get("http://webapps.tekstac.com/FormRegistration/UserRegistration.html");
		
		return driver;
		
	}
	
	public JSONArray readFile(String fileName) {   //Do not change the method signature
	    //Retrieve the json file name passed as 'fileName' parameter. Parse the json, store it in 'details' array and return it
		
		try {
			
			FileReader reader = new FileReader(fileName);
			JSONParser jsonParser = new JSONParser();
			
			Object object = jsonParser.parse(reader);
			
			JSONObject jsonObject = (JSONObject) object;
			
			details = (JSONArray) jsonObject.get("Userdetails");
			
			// System.out.println(details);
			
			return details;
			
			
		} catch (IOException | ParseException e) {
			
			e.printStackTrace();
		}	
		
		return null;
		
	}

	public String getName(int id) {   //Do not change the method signature
		//Parse the json to get 'Name' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String name = (String) userDetailsObject.get("Name");
		
		return name;
		
	}

	public String getEmail(int id) {   //Do not change the method signature
		//Parse the json to get 'Email' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String email = (String) userDetailsObject.get("Email");
		
		return email;
		
	}

	
	
	public String getPhone(int id) {     //Do not change the method signature   
		//Parse the json to get 'Phone' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String phoneNumber = (String) userDetailsObject.get("Phone");
		
		return phoneNumber;
		
	}

	
	public String getAge(int id) {         //Do not change the method signature
		//Parse the json to get 'Age' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String age = (String) userDetailsObject.get("Age");
		
		return age;
		
	}

	
	public String getPassword(int id) {
		//Do not change the method signature
	//Parse the json to get 'Password' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String password = (String) userDetailsObject.get("Password");
		
		return password;
		
		
	}

	
	public String getHobbies(int id) {
		//Do not change the method signature
		//Parse the json to get 'Hobbies' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String hobbies = (String) userDetailsObject.get("Hobbies");
		
		return hobbies;
		
	}

	
	public String getGender(int id) {
		//Do not change the method signature
		//Parse the json to get 'Gender' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String gender = (String) userDetailsObject.get("Gender");
		
		return gender;
		
		
	}

	public String getCity(int id) {
		//Do not change the method signature
		//Parse the json to get 'City' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String city = (String) userDetailsObject.get("City");
		
		return city;
		
		
	}

	public String getAddress(int id) {
		//Do not change the method signature
		//Parse the json to get 'Address' value. Return it.
        //Parameter 'id' is the id in the Registration.json
		
		JSONObject userDetailsObject = (JSONObject) details.get(id);
		
		String address = (String) userDetailsObject.get("Address");
		
		return address;
		
	}

	public String getMessage() {
		//Do not change the method signature
		//Find the web elements in the page. Assign the respective values from json to the form.
        //Submit the form 
        //Locate the 'Registered Successfully' message and return it
		
		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys(getName(1));
		driver.findElement(By.xpath("//input[@id='uemail']")).sendKeys(getEmail(1));
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(getPhone(1));
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys(getAge(1));
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(getPassword(1));
		
		if(getHobbies(1).equalsIgnoreCase("cricket")) {
			driver.findElement(By.xpath("//input[@id='option1']")).click();
			
		}else {
			driver.findElement(By.xpath("//input[@id='option2']")).click();
		}
		
		if(getGender(1).equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//input[@id='male']")).click();
			
		}else {
			driver.findElement(By.xpath("//input[@id='female']")).click();
		}
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='city']")));
		select.selectByVisibleText(getCity(1));
		
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(getAddress(1));
		
		driver.findElement(By.id("submit")).click();
		
		String message = driver.findElement(By.xpath("//html/body/h2")).getText();
		
		return message;		
		
	}

	public static void main(String[] args) {
		UserDetails fieldLocator = new UserDetails();
		//Add required code
		
		createDriver();
		fieldLocator.readFile("Registration.json");
		
		System.out.println(fieldLocator.getMessage());	
		
		driver.quit();
		
	}

}