import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.regex.*;

public class NameLocator { // DO NOT change the class name

	public static String baseUrl; // Assign 'http://webapps.tekstac.com/Handling_Regular_Expression/' for baseUrl
	public static WebDriver driver;

	public WebDriver createDriver() {
		// Create driver. Assign it to static variable 'driver' and return it

		baseUrl = "http://webapps.tekstac.com/Handling_Regular_Expression/";
		driver = DriverSetup.getWebDriver();

		return driver;

	}

	public void navigate(WebDriver driver) {
		// Navigate to the baseUrl
		driver.get(baseUrl);

	}

	public void setFormValues(WebDriver driver) {
		// set the value for 'Shipment for user' and submit form
		driver.findElement(By.id("userId")).sendKeys("Shamili");
		driver.findElement(By.xpath("//button[@id='track']")).click();

	}

	public WebElement getNameResultElement(WebDriver driver) {
		// Find the element of 'Shamili' and return it

		WebElement element = driver.findElement(By.xpath("//div[@id='result']/table/tbody/tr[1]/td[2]"));

		return element;

	}

	public WebElement getShipmentResultElement(WebDriver driver) {
		// Find the element of 'SHIP1236' and return it

		WebElement element = driver.findElement(By.xpath("//div[@id='shipment']"));

		return element;

	}

	public WebElement getEmailResultElement(WebDriver driver) {

		// Find the element of 'shamili93@gamil.com' and return it

		WebElement element = driver.findElement(By.xpath("//div[@id='e- mail']"));

		return element;

	}

	public boolean validateEmail(String eMailID) {
		// Validate email using regex.

		return Pattern.matches("\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b", eMailID);

	}

	public boolean validateShipmentId(String shipmentId) {
		// Validate shipmentId using regex

		return Pattern.matches("[A-Z0-9]{8}", shipmentId);

	}

	public static void main(String[] args) {
		NameLocator reg = new NameLocator();
		// Add required code here
		reg.createDriver();
		reg.navigate(driver);
		reg.setFormValues(driver);
		reg.getNameResultElement(driver);
		String shipmentID = reg.getShipmentResultElement(driver).getText();
		String email = reg.getEmailResultElement(driver).getText();
		
		reg.validateEmail(email);
		reg.validateShipmentId(shipmentID);
		
		
	}

}
