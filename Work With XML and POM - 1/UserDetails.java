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



public class UserDetails{      //Do not change the class name
    
    //use this variable declaration
    public static WebDriver driver;
    
    public static Document document;
    public static XPath xpath;
    
    public static Node node;
   
    
    public static WebDriver createDriver(){   //Do not change the method signature
	
	    /* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'http://webapps.tekstac.com/FormRegistration/UserRegistration.html'  */
    	
    	driver = DriverSetup.getWebDriver();
    	
    	driver.get("http://webapps.tekstac.com/FormRegistration/UserRegistration.html");
    	
    	return driver;
    	
	}
    
    public XPath ReadFile(String fileName,String id){      //Do not change the method signature
        //Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and return the xPath
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	File xmlFile = new File(fileName);
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	
    	try {
    			
		DocumentBuilder builder = factory.newDocumentBuilder();
		
    	document = builder.parse(xmlFile);
    	

    	
    	
    	} catch (ParserConfigurationException | SAXException | IOException e) {
			
			e.printStackTrace();
		}
    	
    	XPathFactory xPathFactory = XPathFactory.newInstance();
    	
    	xpath = xPathFactory.newInstance().newXPath();
    	
    	return xpath;
    	
    }
    
    
    public  Node getName(int id){   //Do not change the method signature
        //Parse the xml to get 'Name' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Name";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    	
    }
    
    public  Node getEmail(int id){   //Do not change the method signature
        //Parse the xml to get 'Email' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Email";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    public  Node getPhone(int id){    //Do not change the method signature
        //Parse the xml to get 'Phone' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Phone";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    public  Node getAge(int id){        //Do not change the method signature
        //Parse the xml to get 'Age' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Age";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    public  Node getPassword(int id){    //Do not change the method signature
        //Parse the xml to get 'Password' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Password";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    
    public  Node getHobbies(int id){    //Do not change the method signature
        //Parse the xml to get 'Hobbies' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Hobbies";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    public  Node getGender(int id){    //Do not change the method signature
        //Parse the xml to get 'Gender' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Gender";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    public  Node getCity(int id){        //Do not change the method signature
        //Parse the xml to get 'City' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/City";
    	
    	try {
			node = (Node) xpath.compile(expression).evaluate(document, XPathConstants.NODE);
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	return node;
    	
    }
    
    
    public  Node getAddress(int id){       //Do not change the method signature
       //Parse the xml to get 'Address' element. Return its node
        //Parameter 'id' is the id in the Userdetails.xml
    	
    	String expression = "//User[@id="+id+"]/Address";
    	
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
        //Locate the 'Registered Successfully' message and return it
    	  
    	  driver.findElement(By.xpath("//input[@id='uname']")).sendKeys(getName(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='uemail']")).sendKeys(getEmail(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(getPhone(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='age']")).sendKeys(getAge(1).getTextContent());
    	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(getPassword(1).getTextContent());
    	  
    	  if(getHobbies(1).getTextContent().equalsIgnoreCase("cricket")) {
    		  driver.findElement(By.xpath("//input[@id='option1']")).click();
    		  
    	  }else {
    		  driver.findElement(By.xpath("//input[@id='option2']")).click();
    		  
    	  }
    	  
    	  
    	  if(getGender(1).getTextContent().equalsIgnoreCase("female")) {
    		  driver.findElement(By.xpath("//input[@id='female']")).click();
    		  
    	  }else {
    		  driver.findElement(By.xpath("//input[@id='male']")).click();
    		  
    	  }
    	  
    	  Select select = new Select(driver.findElement(By.xpath("//select[@id='city']")));
    	  select.selectByVisibleText(getCity(1).getTextContent());
    	  
    	  driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(getAddress(1).getTextContent());
    	  
    	  driver.findElement(By.id("submit")).click();
    	  
    	  String message = driver.findElement(By.xpath("//h2[normalize-space() = 'Registered Successfully']")).getText();
    	  
    	  return message;    	  
        
      }

    public static void main(String[] args){
	    UserDetails pagLocator = new UserDetails();
	    //Add required code here
	    
	    createDriver();
	    pagLocator.ReadFile("Userdetails.xml", "1");
	    System.out.println(pagLocator.getMessage());
	    
	    
	} 
}