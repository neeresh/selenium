import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Main { //Do not change the class name

	public static WebDriver driver;
	public static WebElement element;


	public static WebDriver setDriver() {
	    //Create driver. Assign it to static variable 'driver' and return it.
		
		driver = DriverSetup.getWebDriver();
		
		return driver;
	}

	public static void userName(String user) throws Exception {  
		// Method to locate text box Username by its name & pass the parameter as input
		element = driver.findElement(By.name("username"));
		element.sendKeys(user);
		
	}

	public static void password(String pwd) throws Exception{  
		// Method to locate text box Password by its name & pass the parameter as input
		element = driver.findElement(By.name("password"));
		element.sendKeys(pwd);
		
	}

	public static void clickLoginButton() throws Exception{  
		// Method to locate the Login Button by its name & click it
		element = driver.findElement(By.name("login"));
		element.click();
		
	}

	public static void navigateBackward() {  
		// Method to go to previous page in browser
		// driver.findElement(By.name("username")).clear();
		driver.navigate().back();
		
	}

    public static String getUsernameValue() throws Exception {
        //Follow the same step you are using to get value for 'userText' in the method 'checkText'. Return the 'userText' value.
    	element = driver.findElement(By.name("username"));
    	String userText = element.getAttribute("value");
    	
    	return userText;
    	
    }
    
	public static void checkText(String userNameCheck) throws Exception {
		// Method to validate the data displayed in Username text box with the input you gave
		// Create a string variable 'userText' to store the value from text box
		// And do the validation with the input you already entered
		// Print the result if given input is same or not
		
		String userText = getUsernameValue();
		
		driver.findElement(By.name("name")).clear();
		
		driver.findElement(By.name("username")).sendKeys(userNameCheck);
		
		
		if(userText.equals(getUsernameValue())) {
			System.out.println("same");
		}else {
			System.out.println("not same");
		}
		
		
	}
	public static void closeBrowser() { 
		// Method to close the Browser
		driver.quit();
	}

	public static void main(String[] args) throws Exception {
		// Invoke all the above methods
		// Store "John" in a string 'userName' & use for FirstName 
		// Password input is "War235e36@#"
		
		driver = setDriver();
		String userName = "John";
		userName(userName);
		password("War235e36@#");
		getUsernameValue();
		clickLoginButton();
		navigateBackward();
		checkText("Neeresh");
		closeBrowser();
		
	}
}
