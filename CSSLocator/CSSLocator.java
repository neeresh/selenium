//Add required imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CSSLocator // DO NOT change the class name
{
	
	WebDriver driver;
	
	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and return it
		
		driver = DriverSetup.getWebDriver();
		
		return driver;
		
	}

	public WebElement getCSSLocator(WebDriver driver) // DO NOT change the method signature
	{
		/*
		 * Replace this comment by the code statement to get the Web element of username
		 */
		/* Find and return the element */
		
		WebElement usernameLocator = driver.findElement(By.cssSelector("input[name='usrnm']"));
		
		return usernameLocator;
		
	}

	public String getName(WebElement element) // DO NOT change the method signature
	{
		// Get the attribute value from the element and return it
		
		String placeholder = element.getAttribute("placeholder");
		
		return placeholder;
		
	}

	public static void main(String[] args) {
		CSSLocator csslocator = new CSSLocator();
		
		// Add required code
		csslocator.createDriver();
		WebElement usernameLocator = csslocator.getCSSLocator(csslocator.driver);
		csslocator.getName(usernameLocator);
		
	}
}
