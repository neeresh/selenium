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



public class DiscountCalculator{      //Do not change the class name
    
    //use this variable declaration
    public static WebDriver driver;
    
    public static Document document;
    public static XPath xPath;
    public static Node node;
    
    public static WebDriver createDriver(){   //Do not change the method signature
	
	    /* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'https://webapps.tekstac.com/CompanyOffersDiscount/'  */
    	
    	driver = DriverSetup.getWebDriver();
    	driver.get("https://webapps.tekstac.com/CompanyOffersDiscount/");
    	
    	return driver;	
    	
	}
    
    public XPath ReadFile(String fileName,String id){      //Do not change the method signature
        //Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and return the xPath
        //Parameter 'id' is the id in the DiscountCalculator.xml
    	
    	File xmlFile = new File(fileName);
    	    	
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
    	try {
    		
    		DocumentBuilder builder = factory.newDocumentBuilder();
    		document = builder.parse(xmlFile);    		
    		
    	}catch(ParserConfigurationException | SAXException | IOException e) {
    		e.printStackTrace();
    		
    	}
    	
    	XPathFactory xPathFactory = XPathFactory.newInstance();
    	xPath = xPathFactory.newXPath();
    	
    	return xPath;
    	
    }
    
    public  Node getWeight(int id){   //Do not change the method signature
        //Parse the xml to get 'Weight' element. Return its node
        //Parameter 'id' is the id in the DiscountCalculator.xml
    	
    	String expression = "//Shipmentdetails/Shipmentdetail[@id="+id+"]/Weight";
    	
    	try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    public  Node getDistance(int id){   //Do not change the method signature
        //Parse the xml to get 'Distance' element. Return its node
        //Parameter 'id' is the id in the DiscountCalculator.xml
    	
    	String expression = "//Shipmentdetails/Shipmentdetail[@id="+id+"]/Distance";
    	
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
        //Locate the 'Datax shipping company offers discount' message and return it
    	
    	driver.findElement(By.xpath("//input[@id='weight']")).sendKeys(getWeight(1).getTextContent());
    	driver.findElement(By.xpath("//input[@id='distance']")).sendKeys(getDistance(1).getTextContent());
    	
    	driver.findElement(By.xpath("//button[@id='submit']")).click();
    	
    	String message = driver.findElement(By.xpath("//div[@id='result']")).getAttribute("value");
    	
    	return message;
        
     }

    public static void main(String[] args){
	    DiscountCalculator pagLocator = new DiscountCalculator();
	    //Add required code here
	    
	    createDriver();
	    pagLocator.ReadFile("DiscountCalculator.xml", "1");
	    System.out.println(pagLocator.getMessage());
	    
	    
	    
	} 
}