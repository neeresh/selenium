import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;



public class ShipmentDetail{      //Do not change the class name
    
    //use this variable declaration
    public static WebDriver driver;
    
    public static Document document;
    public static XPath xpath;
    public static Node node;
    
    public static WebDriver createDriver(){   //Do not change the method signature
	
	    /* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'https://webapps.tekstac.com/Handling_Reg_Expression/'  */
    	
    	driver = DriverSetup.getWebDriver();
    	driver.get("https://webapps.tekstac.com/Handling_Reg_Expression/");
    	
    	return driver;
    	
	}
    
    public XPath ReadFile(String fileName,String id){      //Do not change the method signature
        //Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and return the xPath
        //Parameter 'id' is the id in the ShipmentDetail.xml
    	
    	File xmlFile = new File(fileName);
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
    	try {
    		
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(xmlFile);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	XPathFactory xPathFactory = XPathFactory.newInstance();
    	xpath = xPathFactory.newXPath();
    	
    	return xpath;
    	
    }
    
    public  Node getUserId(int id){   //Do not change the method signature
        //Parse the xml to get 'UserId' element. Return its node
        //Parameter 'id' is the id in the ShipmentDetail.xml
    	
    	
    	String expression = "//ShipmentDetails/ShipmentDetail[@id="+id+"]/UserId";
    	
    	try {
    		
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    
    
      public  String  getMessage(){  //Do not change the method signature
        
        //Find the web elements in the page. Assign the respective values from xml to the form.
        //Submit the form 
        //Locate the 'Name : Shamili
        //Shipment Id : SHIP1236
        //Phone Number : 9224158877
        //E-mail: shamili93@gamil.com' message and return it
    	  
    	  driver.findElement(By.xpath("//input[@id='userId']")).sendKeys(getUserId(1).getTextContent());
    	  driver.findElement(By.xpath("//button[@id='track']")).click();
    	  
    	  String message = driver.findElement(By.id("result")).getText();
    	  
    	  return message;
        
      }

    public static void main(String[] args){
	    //Add required code here
    	createDriver();
    	ShipmentDetail details = new ShipmentDetail();
    	details.ReadFile("ShipmentDetail.xml", "1");
    	System.out.println(details.getMessage());
    	
	} 
}