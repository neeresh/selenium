import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerRegistration {

	public static void main(String[] args) throws Exception {

		// Create a document builder factory object & initialize it
		String filePath = "CustomerRegistration.xml";
		File file = new File(filePath);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		WebDriver driver = DriverSetup.getDriver();
		
		String strCustomerName = new String();
		
		// Create a document builder object & initialize it
		DocumentBuilder dBuilder = dbf.newDocumentBuilder();
		Document doc = dBuilder.parse(file);
		doc.getDocumentElement().normalize();
		
		// Create object for node list & node; Initialize them
		NodeList nodeList = doc.getElementsByTagName("Customer");
		Node node = nodeList.item(0);
		Element element = (Element)node;

		// Extract the value from Customer Name node & store in a string
		strCustomerName = element.getElementsByTagName("CustomerName").item(0).getTextContent();
		WebElement custName = driver.findElement(By.xpath("//input[@name='cname']"));
		custName.sendKeys(strCustomerName);

		// Extract the value from Age node & pass it to the "Age" field in application
		WebElement age = driver.findElement(By.xpath("//input[@name='age']"));
		age.sendKeys(element.getElementsByTagName("Age").item(0).getTextContent());

		// Extract the value from Address node & pass it to the "Address" field in application
		WebElement address = driver.findElement(By.xpath("//input[@name='address']"));
		address.sendKeys(element.getElementsByTagName("Address").item(0).getTextContent());
		
		// Extract the value from Phone node & pass it to the "Phone Number" field in application
		WebElement phone = driver.findElement(By.xpath("//input[@name='phonenumber']"));
		phone.sendKeys(element.getElementsByTagName("Phone").item(0).getTextContent());
		
		// Extract the value from Email node & pass it to the "Email" field in application
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys(element.getElementsByTagName("Email").item(0).getTextContent());
		
		driver.close();
	}

}
