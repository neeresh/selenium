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



public class CustomerRegistration{      //Do not change the class name
    
    //use this variable declaration
    public static WebDriver driver;
    
    public static Document document;
    public static Node node;
    public static XPath xPath;
    
    public static WebDriver createDriver(){   //Do not change the method signature
	
	    /* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'https://webapps.tekstac.com/CustomerRegistration_4284/'  */
    	
    	driver = DriverSetup.getWebDriver();
    	driver.get("https://webapps.tekstac.com/CustomerRegistration_4284/");
    	
    	return driver;
    	
	}
    
    public XPath ReadFile(String fileName,String id){      //Do not change the method signature
        //Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and return the xPath
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
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
    	xPath = xPathFactory.newXPath();
    	
    	return xPath;
    	
    }
    
    public  Node getName(int id){   //Do not change the method signature
        //Parse the xml to get 'Name' element. Return its node
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
    	String expression = "//CustomerDetails/Customer[@id="+id+"]/Name";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    public  Node getPhone(int id){    //Do not change the method signature
        //Parse the xml to get 'Phone' element. Return its node
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
    	String expression = "//CustomerDetails/Customer[@id="+id+"]/Phone";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    	
    }
    
    public  Node getDOB(int id){        //Do not change the method signature
        //Parse the xml to get 'DOB' element. Return its node
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
    	String expression = "//CustomerDetails/Customer[@id="+id+"]/DOB";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    	
    }
    
    
    public  Node getGender(int id){    //Do not change the method signature
        //Parse the xml to get 'Gender' element. Return its node
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
    	String expression = "//CustomerDetails/Customer[@id="+id+"]/Gender";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    	
    }
    
    
    public  Node getAddress(int id){       //Do not change the method signature
       //Parse the xml to get 'Address' element. Return its node
        //Parameter 'id' is the id in the CustomerRegistration.xml
    	
    	String expression = "//CustomerDetails/Customer[@id="+id+"]/Address";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    	
    }
    
    
      public  String  getMessage(){  //Do not change the method signature
        
        //Find the web elements in the page. Assign the respective values from xml to the form.
        //Submit the form 
        //Locate the 'Registered Successfully' message and return it
    	  
    	  driver.findElement(By.xpath("//input[@id='name']")).sendKeys(getName(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(getPhone(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getDOB(1).getTextContent());
    	  
    	  if(getGender(1).getTextContent().equalsIgnoreCase("male")) {
    		  driver.findElement(By.xpath("//input[@id='male']")).click();
    		  
    	  }else {
    		  driver.findElement(By.xpath("//input[@id='female']")).click();
    		  
    	  }
    	  
    	  driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(getAddress(1).getTextContent());
    	  
    	  driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
    	  
    	  String message = driver.findElement(By.xpath("//div[@id='errorMessage']")).getText();
    	  
    	  return message;
    	  
      }

    public static void main(String[] args){
	    CustomerRegistration pagLocator = new CustomerRegistration();
	    //Add required code here
	    
	    createDriver();
	    pagLocator.ReadFile("CustomerRegistration.xml", "1");
	    System.out.println(pagLocator.getMessage());
	    
	} 
}