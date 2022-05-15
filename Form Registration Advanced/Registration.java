import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Registration 
{
	static WebDriver driver;
	static String baseUrl; 
	
	public WebDriver setupDriver()
	{
	    //Assign the value for baseUrl
	    /* Get the driver, and launch the app using get() with baseUrl */
	    
	    driver = DriverSetup.getWebDriver();
	    baseUrl = "http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    
	    return driver;
	}
	
	public void setElements()
	{
	   /*Using the driver, Find the elements by id and send the values to the elements*/
		driver.findElement(By.id("firstname")).sendKeys("Mithali");
		driver.findElement(By.id("lastname")).sendKeys("Raj");
		driver.findElement(By.id("username")).sendKeys("Mithali Raj");
		
		Select select = new Select(driver.findElement(By.id("selectcity")));
		select.selectByValue("mas");
		
		driver.findElement(By.cssSelector(".input-ccontainer > input:nth-child(4)")).click();
		driver.findElement(By.id("pass")).sendKeys("MR@123");
		driver.findElement(By.id("reg")).click();
		
	}
	
	public static void main(String[] args)
	{
	    Registration registration = new Registration();
	    
	    //Implement Code Here
	    driver = registration.setupDriver();
	    registration.setElements();
	    
	}

}

