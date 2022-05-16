import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgentRegistration {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String userdir = System.getProperty("user.dir");
		
		WebDriver driver = DriverSetup.getDriver();
		// Create a JSON Parser object & initialize it
		driver = DriverSetup.getDriver();
		
		JSONParser parser = new JSONParser();
		// Create FileReader Object to read Json file
		FileReader reader = new FileReader(userdir + "/AgentRegistration.json");
		
		// A JSON object. Key value pairs are unordered. JSONObject supports
		// java.util.Map interface.
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		
		// Extract the value from First Name node ,store in a string and pass it to the
		// "First Name" field in application
		String Fname = (String) jsonObject.get("First Name");
		WebElement fname = driver.findElement(By.name("firstname"));
		fname.sendKeys(Fname);
		
		// Extract the value from Last Name node and pass it to the "Last Name" field in
		// application
		String Lname = (String) jsonObject.get("Last Name");
		WebElement lname = driver.findElement(By.name("lastname"));
		lname.sendKeys(Lname);
		
		// Extract the value from User Name node and pass it to the "User Name" field in
		// application
		WebElement uname = driver.findElement(By.name("username"));
		uname.sendKeys((String) jsonObject.get("User Name"));
		
		// Extract the value from Password node and pass it to the "Password " field in
		// application
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys((String) jsonObject.get("Password"));
		
		// Extract the value from Phone Number node and pass it to the "Phone Number "
		// field in application
		WebElement phone = driver.findElement(By.name("phonenumber"));
		phone.sendKeys((String) jsonObject.get("Phone Number"));
		
		// Extract the value from Email node and pass it to the "Email " field in
		// application
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys((String) jsonObject.get("Email"));
		
		// Click Submit
		driver.findElement(By.id("submit")).click();
		
		// close the browser
		driver.close();

	}
}
