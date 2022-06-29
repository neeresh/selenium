import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.openqa.selenium.By;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;



public class NameLocator   //DO NOT Change the class Name
{
	
	public static WebDriver driver;
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document document;
	 XPath xpath;
	
	
	public static WebDriver createDriver() //DO NOT change the method signature
	{
	   //Implement code to create Driver from DriverSetup, set to 'static' driver variable and return it
	   driver = DriverSetup.getWebDriver();
	   
	   return driver;
	   
	}
	
	public XPath ReadFile(String xmlfileName,String id)   //DO NOT change the method signature
    {
        //Implement code to read and return XPath object reference
        
        File xmlFile = new File(xmlfileName);
        
        factory = DocumentBuilderFactory.newInstance();
        
        try {
            
            builder = factory.newDocumentBuilder();
            
            document = builder.parse(xmlFile);
            
            xpath = XPathFactory.newInstance().newXPath();
            
            
            return xpath;
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
        
    }
    public  String getFirstName(int id){
        //Implement code to return firstname from xml
    	
        String expression = "/Userdetails/User[@id = "+ id +"]/Firstname";
        
        try {
        	
			String firstName = xpath.compile(expression).evaluate(document);
			
			return firstName;
			
		} catch (XPathExpressionException e) {
			
			e.printStackTrace();
			
			return null;
		}
        
    }
    
    public  String getLastName(int id){
        //Implement code to return lastname from xml
        
    	String expression = "/Userdetails/User[@id = "+ id +"]/Lastname";
    	
    	try {
    		
			String lastName = xpath.compile(expression).evaluate(document);
			
			 return lastName;
			
		} catch (XPathExpressionException e) {
			
			e.printStackTrace();
			
			return null;
		}
        
    }
    
    public  String getUserName(int id){
        //Implement code to return username from xml
        
    	String expression = "/Userdetails/User[@id="+id+"]/Username";
        
    	try {
			
    		String userName = xpath.compile(expression).evaluate(document);
			
			return userName;
			
		} catch (XPathExpressionException e) {
			
			e.printStackTrace();
			
			return null;
		}
        
    }
    
    public  String getPassword(int id){
        //Implement code to return passworf from xml
        
    	String expression = "/Userdetails/User[@id="+id+"]/Password";
        
    	try {
    		
    		String password = xpath.compile(expression).evaluate(document);
    		
    		return password;
		
    	} catch (XPathExpressionException e) {
			
			e.printStackTrace();
			
			return null;
			
		}
        
        
    }
     
     public  String  getMessage(){  
        //Implement code to submit form with values got from xml and return a success message.
        
    	 driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(getFirstName(1));
    	 driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(getLastName(1));
    	 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(getUserName(1));
    	 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(getPassword(1));
    	 
    	 
    	 driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
        
    	 if(driver.findElement(By.xpath("//table/tbody/tr[3]")).isDisplayed()) {
    		 
    		 return "Registered Successfully";
    	
    	 }
    	 
    	 return null;
        
        
      }   
      
      public static void main(String[] args)
	{
	    NameLocator pagLocator = new NameLocator();
	   //Implement the required code
	    //Close the driver
	    pagLocator.createDriver();
	    pagLocator.ReadFile("Userdetails.xml", "1");
	    pagLocator.getFirstName(1);
	    pagLocator.getLastName(1);
	    pagLocator.getUserName(1);
	    pagLocator.getPassword(1);
	    System.out.println(pagLocator.getMessage());
	    
	    
	}

}

