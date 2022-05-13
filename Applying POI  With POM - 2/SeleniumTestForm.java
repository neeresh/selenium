import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestForm { // DO NOT change the class name

	// Use this declarations to store respective values
	public static WebDriver driver;
	public static String result = new String();
	public static String msg1, msg2;
	
//	public static WebElement element;

	public void createDriver() {
		// Implement code to create driver and assign it to 'static' driver variable

		driver = DriverSetup.getWebDriver();

	}

	static String flag;
	
	public void testSeleniumTestForm(String weight, String transportMode) throws Exception {
		// 'weight' and 'transportMode' parameter are used to send the values to the
		// form
		// find the elements in the form and set values as per description. Submit the
		// form.
		// Find the element of the message displayed after submit. Store it in 'result'
		// variable.
		// compare it with the message as given in the problem statement.
		
		driver.findElement(By.xpath("//input[@id='weight']")).sendKeys("200");
		
		if(transportMode.equalsIgnoreCase("air")) {
			driver.findElement(By.xpath("//input[@id='air']")).click();
			
		}else if(transportMode.equalsIgnoreCase("road")) {
			driver.findElement(By.xpath("//input[@id='road']")).click();
			
		}else if(transportMode.equalsIgnoreCase("ship")) {
			driver.findElement(By.xpath("//input[@id='ship']")).click();
			
		}
		
		driver.findElement(By.xpath("//button[normalize-space()='Calculate']")).click();
		
		msg1 = driver.findElement(By.xpath("//div[@id='result']")).getText();
		msg2 = "Dear Customer, your total shipping cost is $200";
		
		if(msg1.equals(msg2)) {
			result = "pass";
		}else {
			result = "fail";
		}
		
		CargoShipping.writeExcelData("cargo.xlsx", result);

	}

	public void closeBrowser() {
		// close the browser
		driver.quit();
		
	}

	public static void main(String[] args) throws Exception {

		SeleniumTestForm test = new SeleniumTestForm();
		// Add code here
		test.createDriver();
		test.testSeleniumTestForm("200", "air");
		

	}
}