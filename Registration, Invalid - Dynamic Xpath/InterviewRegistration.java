import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InterviewRegistration {// Do not change class name
	// Use the below declarations
	public static WebDriver driver;
	public static String result;
	public static WebElement element;
	public static List<WebElement> rlist;

	
	public WebDriver createDriver() { // Do not change the method signature
		// Create the driver using 'getWebDriver' method. Assign it to variable 'driver'
		// Return the variable driver
		driver = DriverSetup.getWebDriver();
		
		return driver;
		
	}

	
	public void setFormValues(String name, String age, String gender, String dob, String degree, String sslcperc,
			String higherperc, String ugperc, String skills, String aboutYou) {   // Do not change the method signature
		// Find the form elements using only relative xpath and set the parameter values

		// Enter data into "Name" text box
		element = driver.findElement(By.xpath("//input[@name='Name']"));
		element.sendKeys(name);
	
		// Enter data into "Age" text box
		element = driver.findElement(By.xpath("//input[@name='age']"));
		element.sendKeys(age);

		// Select Gender from available radio buttons; so store all the radio button
		// options in a list
		rlist = driver.findElements(By.xpath("//input[@name='gender']"));
		
		// Check the passed value and select the appropriate radio button
		if(gender.equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//input[@name='gender'][1]")).click();
		}else {
			driver.findElement(By.xpath("//input[@name='gender'][2]")).click();
		}
		
		// Use JavascriptExecutor to change Input tag's type attribute - from date to text
		// Then enter date value [pass value in mm/dd/yyyy format]
		// element = driver.findElement(By.xpath("//input[@name='dob']"));
		
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		// Creating the JavascriptExecutor interface object by Type casting
		javascript.executeScript("document.getElementById('dob').setAttribute('type', 'text')");
		
		//String date = "16/02/1987";		 
		javascript.executeScript("document.getElementById('dob').value = '"+ dob +"'");

		// select a Degree from the drop down
		element = driver.findElement(By.xpath("//select[@name='degree']"));
		Select select = new Select(element);
		select.selectByVisibleText(degree);

		// Enter whole number < 65 for SSLC Percentage
		element = driver.findElement(By.xpath("//input[@name='sslc']"));
		element.sendKeys(sslcperc);

		// Enter whole number < 65 for HSC / Diploma Percentage
		element = driver.findElement(By.xpath("//input[@name='hsc']"));
		element.sendKeys(higherperc);

		// Enter whole number < 65 for UG Percentage
		element = driver.findElement(By.xpath("//input[@name='ug']"));
		element.sendKeys(ugperc);

		// Use switch case to select a specific checkbox for skill
		switch (skills) {
		case "C Programming":
			driver.findElement(By.xpath("//input[@id=\"c\"]")).click();
			break;
		case "C++ Programming":
			driver.findElement(By.xpath("//input[@id=\"cpp\"]")).click();
			break;
		case "Java Programming":
			driver.findElement(By.xpath("//input[@id=\"java\"]")).click();
			break;
		case "Python Programming":
			driver.findElement(By.xpath("//input[@id=\"py\"]")).click();
			break;
		case "Angular JS":
			driver.findElement(By.xpath("//input[@id=\"ajs\"]")).click();
			break;
		case "C#":
			driver.findElement(By.xpath("//input[@id=\"cs\"]")).click();
			break;
		}

		// Enter data into "About You" textarea
		element = driver.findElement(By.xpath("//textarea[@name = 'aboutYou']"));
		element.sendKeys(aboutYou);

		// Click on Submit
		element = driver.findElement(By.xpath("//a[@id='submit']"));
		element.click();
		
	}

	public static String interviewMsg() { // Do not change the method signature
	
		// This method will get the text displayed as a output after form submission
		// Find the form element for getting the Output text.
		// Return the result message
		
		element = driver.findElement(By.xpath("//label[@id='message']"));
		result = element.getText();
		
		return result;
		
	}

	// Do not change the method signature
	public void closeBrowser() {
		// close the driver
		driver.quit();
		
	}

	
	public static void main(String[] args) { // Do not change the method signature
		InterviewRegistration intrwReg = new InterviewRegistration();

		// Implement the code
		// Invoke createDriver() method
		intrwReg.createDriver();

		// Invoke 'setFormValues' method, pass the values for String name, String age,
		// String gender, String dob, String degree, String sslcperc,
		// String higherperc, String ugperc, String skills, String aboutYou
		intrwReg.setFormValues("Daniel", "23", "Male", "02/16/1987", "B.Sc", "64", "63", "60", "C++ Programming", "Self developing career");

		// Invoke interviewMsg() method and store the returned message in String 'result'
		result = interviewMsg();
		
		// Print the result message in the console
		System.out.println(result);

		// Invoke closeBrowser() method
		intrwReg.closeBrowser();
		
	}
}
