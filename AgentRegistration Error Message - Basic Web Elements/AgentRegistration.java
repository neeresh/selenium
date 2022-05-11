import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgentRegistration { //DO NOT change the class name
	static WebDriver driver;

	public WebDriver createDriver(){
		//Create driver, store in in static variable 'driver' and return it
		
		driver = DriverSetup.getWebDriver();
		driver.get("https://webapps.tekstac.com/Agent_Registration/");
		
		return driver;
	}


	public void setNewFormValues(String firstname,String lastname,String username,String password,String phonenumber,String email){
		//Find the form elements and set values by passing those values from 'main' method. 
		//Submit invalid details to retrieve the error message
		
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("phonenumber")).sendKeys(phonenumber);
		driver.findElement(By.name("email")).sendKeys(email);
		
		driver.findElement(By.id("submit")).click();
		
	}
	public String getErrorMessage(){
		//locate the error message and retrieve the text using gettext
		
		return driver.findElement(By.id("message")).getText();
		
	}


	public void Reset(){
		//Navigate to the previous page and check reset
		
		driver.findElement(By.id("reset")).click();
		
	}


	public static void main(String[] args) {
		AgentRegistration agentregistration = new AgentRegistration();
		
		//Add required code
		driver = agentregistration.createDriver();
		agentregistration.setNewFormValues("perla", "perla", "perla", "perla", "9856327584", null);
		agentregistration.getErrorMessage();
		agentregistration.Reset();
		
		
		
		
		
	}
}
