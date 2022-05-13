import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class SeleniumTestForm { // Do not change the class name

	public static WebDriver driver;
	public static WebElement element;
	
	public void createDriver() { // Do not change the method signature
		// Implement code to create driver and assign it to 'static' driver variable
		
		driver = DriverSetup.getWebDriver();
		

	}

	public void testSeleniumTestForm() { // Do not change the method signature
		// Read the data from excel sheet. Sheet name is 'customervalid'
		// find the elements in the form and set values parsed from excel sheet. Submit
		// the form for registration
		
		element = driver.findElement(By.xpath("//input[@name='cname']"));
		element.sendKeys(CusRegExcel.customerData[0]);
		
		element = driver.findElement(By.xpath("//input[@name='age']"));
		element.sendKeys(CusRegExcel.customerData[1]);
		
		element = driver.findElement(By.xpath("//input[@name='address']"));
		element.sendKeys(CusRegExcel.customerData[2]);
		
		element = driver.findElement(By.xpath("//input[@name='phonenumber']"));
		element.sendKeys(CusRegExcel.customerData[3]);
		
		element = driver.findElement(By.xpath("//input[@name='email']"));
		element.sendKeys(CusRegExcel.customerData[4]);
		
		element = driver.findElement(By.xpath("//input[@id='submit']"));
		element.click();
		
		
		
	}

	public void closeBrowser() {
		// close the browser
		driver.quit();
		
	}

	public static void main(String[] args) throws Exception {
		CusRegExcel customer = new CusRegExcel();
		// Add required code
		customer.readExcelData("CustReg.xlsx");
		customer.getExcelPath("customervalid");
		
// 		SeleniumTestForm test = new SeleniumTestForm();
// 		test.createDriver();
// 		test.testSeleniumTestForm();
		
	}
}