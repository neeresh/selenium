import static org.testng.Assert.assertEquals;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.junit.*;
import org.junit.Test;

public class TestUserDetails {//do not change the class name

    // Use the below declarations
	public static WebDriver driver;
	UserDetails user;

	public static String[] data;
	
	public static String emailerrtxt;  // Store the email error message in this variable
	public static String mobileerrtxt; // Store the mobile error message in this variable
	public String emailwarning="Invalid Email";
	public String mobilewarning="Invalid MobileNumber";
	
	
	//Apply the required annotation
	@BeforeMethod
	public void setUp() {
		//create the driver using method 'getDriver' in class DriverSetup.
		//Assign it to the variable 'driver'
		
		driver = DriverSetup.getDriver();
	
	    // Do not modify this 
		user=new UserDetails(driver);

	}

	public static String[] getExcelData() throws Exception {

		//Call the method 'readExcelData' in class 'ExcelUtils' using sheet name 'user_invalid'
		//Return the value
		
		data = ExcelUtils.readExcelData("user_invalid");
		
		return data;
	
	}
	
	
	//Apply the required annotation
	@Test
	public void testInvalidUserdetails() throws Exception {	
	    
		//get the excel data 
		data = getExcelData();
		
		//pass the data to the form using the required meth
		//eg:emicalc.setName(data[0]);
		//Submit the form
		user.setName(data[0]);
		user.setAddress(data[1]);
		user.setMobile(data[2]);
		user.setEmail(data[3]);
		user.submit();
	
		//call the method to return the errrormessage for mobile field
		//Store it in a global static variable 'mobileerrtxt'
		//print the error message displayed in the application
		//use the declared mobilewarning variale for assertion
		
		mobileerrtxt = user.getMobileWarning();
		System.out.println(mobileerrtxt);
		assertEquals(mobileerrtxt, mobilewarning);
		
		//call the method to return the errormessage for email field.
		//Store it in a global static variable 'emailerrtxt'
	    //print the error message displayed in the application
		//retrieve the error message for email field and assert the value 
		
		emailerrtxt = user.getMobileWarning();
		System.out.println(emailerrtxt);
		assertEquals(emailerrtxt, emailwarning);
		
	}


	//Apply the required annotation
	@AfterMethod
	public void tearDown() {
		//close the browser
		driver.close();
	
	}
}

