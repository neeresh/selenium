//Add required imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsoluteXpathLocator // DO NOT Change the class Name
{
	WebDriver driver;
	
	public WebDriver createDriver() {
		// Implement code to create Driver from DriverSetup and return it
		driver = DriverSetup.getWebDriver();
		
		return driver;
		
	}

	public WebElement getAbsoluteXpathLocator(WebDriver driver)// DO NOT change the method signature
	{
		/* Replace this comment by the code statement to get the Web element of logo */
		/* Find and return the element */
		
		WebElement logo = driver.findElement(By.xpath("/html/body/form/div[1]/img"));
		
		return logo;

	}

	public String getName(WebElement element) // DO NOT change the method signature
	{
		// Get the attribute value from the element and return it
		
		String attributValue = element.getAttribute("src");
		
		return attributValue;
		
	}

	public static void main(String[] args) {
		AbsoluteXpathLocator locator = new AbsoluteXpathLocator();
		// Add required code
		locator.createDriver();
		
		WebElement element = locator.getAbsoluteXpathLocator(locator.driver);
		locator.getName(element);
		
		
	}

}
