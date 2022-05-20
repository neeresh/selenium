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

public class CommodityDetails { // Do not change the class name

	// Use the below declarations
	public static WebDriver driver;
	public static XPath xPath;

	public static String name, weight, length, width, height;

	public static Document document;
	public static Node node;

	public static WebDriver createDriver() { // Do not change the method signature
		// Create the driver using the class 'DriverSetup'. Assign it to the variable
		// 'driver' and return it.
		// Use URL, "http://webapps.tekstac.com/CommodityDetails/"

		driver = DriverSetup.getWebDriver();
		driver.get("http://webapps.tekstac.com/CommodityDetails/");

		return driver;

	}

	public static XPath readFile(String fileName, String id) { // Do not change the method signature
		// Pass fileName and commodity id as parameter
		// Parse the xml file. Return the xpath reference

		File xmlFile = new File(fileName);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(xmlFile);

		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		XPathFactory xPathFactory = XPathFactory.newInstance();

		xPath = xPathFactory.newInstance().newXPath();

		return xPath;

	}

	public static Node getName(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse name and return it node.

		String expression = "//Commoditydetails/Commodity[@id=" + id + "]/Name";

		try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return node;

	}

	public static Node getWeight(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse weight and return it node.

		String expression = "//Commoditydetails/Commodity[@id=" + id + "]/Weight";

		try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return node;

	}

	public static Node getLength(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse length and return it node.

		String expression = "//Commoditydetails/Commodity[@id=" + id + "]/Length";

		try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return node;

	}

	public static Node getWidth(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse width and return it node.

		String expression = "//Commoditydetails/Commodity[@id=" + id + "]/Width";

		try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return node;

	}

	public static Node getHeight(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse heigth and return it node.

		String expression = "//Commoditydetails/Commodity[@id=" + id + "]/Height";

		try {
			node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);

		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return node;

	}

	public static void readInsertedData() { // Do not change the method signature
		// Locate the row displayed on the page after submit.
		// Find the text of of name,weight,height,width and length and store it in
		// respective variables declared above
		
		
		
		name = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
		weight = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
		length = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
		width = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
		height = driver.findElement(By.xpath("//tr[2]/td[5]")).getText();
		
	}

	public static String getCommodityCount() { // Do not change the method signature
		// Locate commodity count value after submit and return it
		String count = driver.findElement(By.xpath("//input[@id='count']")).getAttribute("value");
		System.out.println(count);
		return count;

	}

	public static String getTotalComWeight() { // Do not change the method signature
		// Locate total weight value after submit and return it

		String total = driver.findElement(By.id("total")).getAttribute("value");
		System.out.println(total);
		return total;

	}

	public static void submitForm(int id) { // Do not change the method signature
		// Locate the form elements and send the values parsed from xml.
		// Submit the form.
		// Pass commodity id as parameter

		driver.findElement(By.id("name")).sendKeys(getName(id).getTextContent());
		driver.findElement(By.id("weight")).sendKeys(getWeight(id).getTextContent());
		driver.findElement(By.id("length")).sendKeys(getLength(id).getTextContent());
		driver.findElement(By.id("width")).sendKeys(getWidth(id).getTextContent());
		driver.findElement(By.id("height")).sendKeys(getHeight(id).getTextContent());

		driver.findElement(By.id("add")).click();

	}

	public static void main(String[] args) {
		CommodityDetails commodity = new CommodityDetails();
		// Implement code here
		createDriver();
		readFile("commodity.xml", "1");
		submitForm(1);
		
		readInsertedData();
		
		getCommodityCount();
		getTotalComWeight();

	}

}