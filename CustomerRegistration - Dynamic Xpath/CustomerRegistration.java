import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerRegistration {
    //Do not change the code template 
    //use the below declared variables
	static WebDriver driver;
	public static WebElement element;
	public String[] data = {null, null, null, null, null};

	public WebDriver createDriver(){
		//Create driver, store in in static variable 'driver' and return it
		driver = DriverSetup.getWebDriver();
		
		return driver;
		
	}

	public void setForm(String name,String age,String address,String phone_number,String email){
		/*create a string array and intialise the values given */
		/*identify one xpath and iterate the loop to pass all the values in the form using string array values */
		/*identify the incremental index in the xpath inorder to iterate the loop*/
		
		data[0] = name;
		data[1] = age;
		data[2] = address;
		data[3] = phone_number;
		data[4] = email;
		
		for(int i=0; i<=4; i++) {
			element = driver.findElement(By.xpath("//tbody/tr[" + (i+1) + "]/td/input"));
			element.sendKeys(data[i]);
		}
		
		//submit the form
		element = driver.findElement(By.xpath("//input[@type='submit']"));
		element.click();
		
		//Retrieve the successful submission message after submitting the form
		element = driver.findElement(By.xpath("//h2"));
		String message = element.getText();
		
	}

	public void formReset(){
		//navigate to the previous page and click 'Reset' button to reset the form
		driver.navigate().back();
		element = driver.findElement(By.xpath("//input[@type='reset']"));
		element.click();
		
	}
	public static void main(String[] args){
		CustomerRegistration customer = new CustomerRegistration();
		/*add the required code */
		customer.createDriver();
		customer.setForm("John", "45", "Chennai", "97654321", "jk@gmail.com");
		customer.formReset();
		
	}
}
