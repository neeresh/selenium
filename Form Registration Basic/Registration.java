import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class Registration 
{
	String fName;
	static WebDriver driver;
	static String baseUrl; 
	
	public WebDriver setupDriver()
	{
	    
	    /* Invoke the getWebDriver method 
	       Set value of BaseUrl
	       Launch the app using get() with baseUrl */
		
		driver = DriverSetup.getWebDriver();
		baseUrl = "http://webapps.tekstac.com/Shopify/";
		driver.get(baseUrl);
		
		return driver;
	}
	
	public void setElements()
	{
	    /*Using the driver, Find the elements by id 
	      Set the values to the elements
	      Register the form*/
		
		driver.findElement(By.id("firstname")).sendKeys("Rahul");
		driver.findElement(By.id("lastname")).sendKeys("Dravid");
		driver.findElement(By.id("username")).sendKeys("Rahul Dravid");
		driver.findElement(By.id("pass")).sendKeys("rahuldravid");
		driver.findElement(By.id("reg")).click();
		
	}
	
	public static void main(String[] args)
	{
	    Registration register = new Registration();
	    /* Implement the code here */
	    driver = register.setupDriver();
	    register.setElements();
	    
	   
	}

}

