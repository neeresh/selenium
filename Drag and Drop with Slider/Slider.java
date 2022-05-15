import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

public class Slider{  //DO NOT Change the class Name
	
	static String baseUrl="http://webapps.tekstac.com/OnlineShopping/fashion.html"; 
	public static WebDriver driver;
	public static String productInfo;
    public static String quantityInfo;
    public static String priceInfo;
    
	
	public WebDriver createDriver(){       //DO NOT change the method signature
	   // Implement code to create Driver from DriverSetup and return it
	   // Get the Web Driver and assign it to the driver variable
	   // navigate to the baseUrl
       // return driver
		
		driver = DriverSetup.getWebDriver();
		driver.get(baseUrl);
		
		return driver;
		
	}
	
	public void implDragnDrop(){   //DO NOT change the method signature
	
        // Locate the source web element that needs to be dragged.

        // Locate the target web element that needs to be dropped.      

        // Creating object of Actions class to build composite actions

        // Performing the drag and drop action
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable1']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();

	}
	
	public void implMoveSlider(){   //DO NOT change the method signature
	    // Creating object of Actions class to build composite actions

        // Locate the slider web element

        // Move the slider to '5'

        // For Example

            // You can use the below methods to move the slider

            // * moveToElement(WebElement target)

            // * dragAndDropBy(WebElement source, int xOffset, int yOffset)

            // xOffset value is chosen as given below
                
                // a. If the 'kg' value is 5 the xOffset is "-10"
                // b. If the 'kg' value is 4 the xOffset is "-20"

                // c. If the 'kg' value is 3 the xOffset is "-40"

                // d. If the 'kg' value is 6 the xOffset is "10"

                // e. If the 'kg' value is 7 the xOffset is "20"

            // yOffset value is default '0'
		
		Actions action = new Actions(driver);
		WebElement slider = driver.findElement(By.xpath("//input[@id='myRange']"));
		action.dragAndDropBy(slider, -10, 0).build().perform();
		
	}
	
	public String getProductDetail(){ //DO NOT change the method signature
    
        // Locate the text displaying the product name. 

        // Assign the displaying text to the static variable 'productInfo'

        // Return the text using getText() method.
		
		WebElement productLocator = driver.findElement(By.xpath("//span[@id='product']"));
		productInfo = productLocator.getText();
		
		return productInfo;
		
    }
    
    
    public String getQuantityDetail(){ //DO NOT change the method signature

        // Locate the text displaying the product quantity(No). 

        // Assign the displaying text to the static variable 'quantityInfo'

        // Return the text using getText() method.
    	
    	WebElement quantityLocator = driver.findElement(By.xpath("//span[@id='No']"));
    	quantityInfo = quantityLocator.getText();
    	
    	return quantityInfo;
    	
    }
   
   
    public String getPriceDetail(){  //DO NOT change the method signature
        // Locate the text displaying the product price. 

        // Assign the displaying text to the static variable 'priceInfo'

        // Return the text using getText() method.
    	
    	WebElement priceLocator = driver.findElement(By.xpath("//span[@id='price']"));
    	priceInfo = priceLocator.getText();
    	
    	return priceInfo;
    	
    }

	public static void main(String[] args){          //DO NOT change the method signature
	    Slider slider = new Slider();
	    
	    //Implement the required code
	    //Close the driver
	    
	    slider.createDriver();
	    slider.implDragnDrop();
	    slider.implMoveSlider();
	    slider.getProductDetail();
	    slider.getQuantityDetail();
	    slider.getPriceDetail();   
	    
	}
}

