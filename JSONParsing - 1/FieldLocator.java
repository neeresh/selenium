import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FieldLocator // DO NOT Change the class Name
{
	JSONArray address;

	public static WebDriver driver;

	FileReader reader;
	JSONParser jsonParser = new JSONParser();
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray = new JSONArray();

	JSONObject insideAddresses = new JSONObject();

	public static WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and set to 'static' driver
		// variable. Return the driver.

		driver = DriverSetup.getWebDriver();

		return driver;

	}

	public JSONArray ReadFile(String fileName) // DO NOT change the method signature
	{
		// Implement code to read and return addresses as JSON array

		try {

			reader = new FileReader(fileName);

			Object object = jsonParser.parse(reader);

			JSONObject jsonObject = (JSONObject) object;

			jsonArray = (JSONArray) jsonObject.get("Addresses");

			return jsonArray;

		} catch (IOException | ParseException e) {

			e.printStackTrace();

			return null;

		}

	}

	public String getNickName(int id) {

		// Implement code to return nickname from address

		String nickName;

		insideAddresses = (JSONObject) jsonArray.get(id);

		nickName = (String) insideAddresses.get("NickName");

		return nickName;

	}

	public String getContactName(int id) {
		// Implement code to return contactname from address

		String contactName;

		insideAddresses = (JSONObject) jsonArray.get(id);

		contactName = (String) insideAddresses.get("ContactName");

		return contactName;

	}

	public String getCity(int id) {
		// Implement code to return city from address

		String city;

		insideAddresses = (JSONObject) jsonArray.get(id);

		city = (String) insideAddresses.get("City");

		return city;

	}

	public String getType(int id) {
		// Implement code to return type from address

		String type;

		insideAddresses = (JSONObject) jsonArray.get(id);

		type = (String) insideAddresses.get("Type");

		return type;

	}

	public String getMessage() {
		// Implement code to submit form with values got from json and return a success
		// message.

		driver.findElement(By.xpath("//input[@id='nickname']")).sendKeys(getNickName(1));
		driver.findElement(By.xpath("//input[@id='contact']")).sendKeys(getContactName(1));
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(getCity(1));
		driver.findElement(By.xpath("//input[@id='type']")).sendKeys(getType(1));
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

		if (driver.findElement(By.xpath("//div[@id='result']//table")).isDisplayed()) {

			String message = "Registered Successfully";
			return message;
		}

		return null;
	}

	public static void main(String[] args) {
		FieldLocator pagLocator = new FieldLocator();
		// Implement the required code
		// Close the driver

		driver = createDriver();
		pagLocator.ReadFile("AddressBook.json");

		String message = pagLocator.getMessage();

		System.out.println(message);

		driver.quit();

	}

}
