import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDetails { //Do not change the class name

	public WebDriver driver;
	public WebElement element;

	//Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
	public UserDetails(){}

	public UserDetails(WebDriver driver){
		this.driver= driver;
	}

	public void setName(String name) {
	    
	    //locate and fill the input box of the 'Name' with 'name'
		element = driver.findElement(By.xpath("//input[@id='name']"));
		element.sendKeys(name);
		
	}
	
	public void setAddress(String address) {
	    
		//locate and fill the input box of the 'Address' with 'address'
		element = driver.findElement(By.xpath("//textarea[@id='address']"));
		element.sendKeys(address);
	}
	
	public void setMobile(String mobile) {
	    
		//locate and fill the input box of the 'Mobile Number' with 'mobile'
		element = driver.findElement(By.xpath("//input[@id='mobile']"));
		element.sendKeys(mobile);	
	}
	
	public void setEmail(String email) {
	    
		//locate and fill the input box of the 'Email' with 'email'
		element = driver.findElement(By.xpath("//input[@id='email']"));
		element.sendKeys(email);	
	}
	
	public void submit() {
	    
		//locate and submit the button
		element = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		element.click();
		
	}

	public String getMobileWarning() {
	    
		//locate and retrieve the erromessage for 'MobileNumber'
		//return the text using getText()
		
		element = driver.findElement(By.xpath("//div[@id='mobileWarning']"));
		return element.getText();		
		
	}
	
	public String getEmailWarning() {
	    
		//locate and retrieve the erromessage for 'email'
		//return the text using getText()
		element = driver.findElement(By.xpath("//div[@id='emailWarning']"));
		return element.getText();		
	}
	
}

