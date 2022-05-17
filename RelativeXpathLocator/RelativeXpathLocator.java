
//Add required imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpathLocator // DO NOT Change the class Name
{

	WebDriver driver;

	public WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup and return it

		driver = DriverSetup.getWebDriver();

		return driver;

	}

	public WebElement getRelativeXpathLocator(WebDriver driver)// DO NOT change the method signature
	{
		/* Replace this comment by the code statement to get the Web element */
		/* Find and return the element */

		WebElement userName = driver.findElement(By.xpath("//tr[@id='tbrow']/td[3]"));

		return userName;

	}

	public String getName(WebElement element)// DO NOT change the method signature
	{
		// Get the attribute value from the element and return it

		String userNameValue = element.getText();

		return userNameValue;

	}

	public static void main(String[] args) {
		RelativeXpathLocator pl = new RelativeXpathLocator();
		// Add required code

		pl.createDriver();
		WebElement relativeXpathLocator = pl.getRelativeXpathLocator(pl.driver);
		pl.getName(relativeXpathLocator);

	}
}
