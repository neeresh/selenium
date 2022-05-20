import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor { // Do not change the class name

	// Use the below declarations
	public static WebDriver driver;
	public static Object jsfname, jslname, jsuname, jspwd, jsphone, jsemail, jssubmit, jsreset;

	public WebDriver createDriver() {
		// Create the driver using the class DriverSetup. Assign it to the variable
		// 'driver' and return it.

		driver = DriverSetup.getWebDriver();

		return driver;

	}

	public void submitForm(String fname, String lname, String uname, String pwd, String phone, String email) {
		
		JavascriptExecutor javascript = ((JavascriptExecutor) driver);

		// Using javascript executor, locate the elements of
		// 'firstname','lastname','username','password'
		// 'phonenumber','email' and send the received values.
		// Submit the form

		jsfname = javascript.executeScript("return document.getElementsByName('firstname')[0]");
		javascript.executeScript("arguments[0].value = '"+ fname + "	'", jsfname);

		jslname = javascript.executeScript("return document.getElementsByName('lastname')[0]");
		javascript.executeScript("arguments[0].value =  '" + lname +"'" , jslname);

		jsuname = javascript.executeScript("return document.getElementsByName('username')[0]");
		javascript.executeScript("arguments[0].value = '" + uname +"'", jsuname);

		jspwd = javascript.executeScript("return document.getElementsByName('password')[0]");
		javascript.executeScript("arguments[0].value = '" + pwd +"'", jspwd);

		jsphone = javascript.executeScript("return document.getElementsByName('phonenumber')[0];");
		javascript.executeScript("arguments[0].value = '" + phone +"'", jsphone);

		jsemail = javascript.executeScript("return document.getElementsByName('email')[0];");
		javascript.executeScript("arguments[0].value = '" + email +"'", jsemail);

		jssubmit = javascript.executeScript("return document.getElementById('submit')");
		javascript.executeScript("arguments[0].click()", jssubmit);
		
	}

	public void reset() {
		JavascriptExecutor javascript = ((JavascriptExecutor) driver);
		// Using javascript executor, locate the element reset and click it.
		jsreset = (WebElement) javascript.executeScript("return document.getElementById('reset')");
		javascript.executeScript("arguments[0].click()", jsreset);

	}

	public static void main(String[] args) {
		JavaScriptExecutor at = new JavaScriptExecutor();
		at.createDriver();
		at.reset();
		// Use this values to submit the form
		at.submitForm("Rahul", "Dravid", "Rahul", "rahul@123", "6232126711", "rahultest@gmail.com");

	}

}