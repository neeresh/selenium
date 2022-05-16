import java.util.Iterator; // imported
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Point;

public class MultipleWindows { //Do not change the class name
    
    //Use these declarations to store respective values
    static String parentWinHandle;
    static String childWinHandle;
    Set<String> winHandles;
    
    static WebDriver driver;
	
	public WebDriver createDriver() //Do not change the method signature
	{
	    /* Replace this comment by the code statement to create driver, assign it to 'static' variable and return the driver */
		driver = DriverSetup.getWebDriver();
		
		return driver;
		
	}
	
    public String getParentWindow() throws Exception { //Do not change the method signature
        // Get  Parent Window Handle as string and return it
    	
    	parentWinHandle = driver.getWindowHandle();
    	
    	return parentWinHandle;
    	
    }
    
    public String  getChildWindow() throws Exception { //Do not change the method signature
        
        // Click the href link. Find the child window's handle and return it.
        //Hint: WAIT for child page to load and find the child window handle.
    	
    	driver.findElement(By.linkText("Click to calculate EMI")).click();
    	
    	// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	childWinHandle = driver.getWindowHandle();
    	
    	return childWinHandle;
    	
    }
    
      
    
    public static void main(String[] args){ //Do not change the method signature
	    MultipleWindows win = new MultipleWindows();
	    //Implement code here
	    win.createDriver();
	    try {
			win.getParentWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    try {
			win.getChildWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	    
	    
	    
	   
	}
}