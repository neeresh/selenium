import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomizedXpath {
	// Do not change the code
	// Use the below declarations
	static int textBoxcount, labelsCount, buttonCount; // Store the total count of textbox, label and button in these
														// variables
	static WebDriver driver;
	List<WebElement> textBox, labelsrow, button;

	By countXpath, labelXpath1, labelXpath2, labelXpath3, buttonXpath;

	WebElement row2xpathelement1, row2xpathelement2;

	String labelTexts, buttonText;

	public WebDriver setDriver() {
		/* Invoke the Webdriver */
		/* store in in static variable 'driver' and return it */
		driver = DriverSetup.getDriver();

		return driver;

	}

	public void printCount() {

		/*
		 * Identify the text fields by customized xpath print how many text boxes in the
		 * page using List
		 */
		// Select 'all text boxes and store that in a list ( Use customized xpath
		// locator to identify the elements )
		// Assign your locator to countXpath variable and use that to locate the element

		// Get the count of elements and store the textboxes count in a variable
		// 'textBoxcount'

		// print 'textBoxcount' that stored the value(count of text boxes)

		countXpath = By.xpath("//input[@type='text']");
		textBox = driver.findElements(countXpath);
		textBoxcount = textBox.size();
		System.out.println(textBoxcount);

	}

	public void printLabels() {
		// Identify the text field labels by customized xpath
		// print how many labels in the page
		// Assign your locator to labelXpath1 variable and use that to locate the labels
		// of row 1

		// Assign your locator to labelXpath2 variable and use that to locate the first
		// label of row 2

		// Assign your locator to labelXpath3 variable and use that to locate the second
		// label of row 2

		// Add row 2 web elements in list labelsrow

		// store the Labels count in a variable 'labelsCount'

		// put a loop to print all the label text of web elements stored in labelsrow

		// print 'labelsCount' that stored the value (count of Labels)

		labelXpath1 = By.xpath("//table[@id='myTable']//tr[2]/td/input[@type='text']");
		labelXpath2 = By.xpath("//div[@id='result']/table//tr/td[2]/input[@type='text']");
		labelXpath3 = By.xpath("//div[@id='result']/table//tr/td[4]/input[@type='text']");

		row2xpathelement1 = driver.findElement(labelXpath2);
		row2xpathelement2 = driver.findElement(labelXpath3);

		labelsrow = new ArrayList<WebElement>();

		labelsrow.addAll(driver.findElements(labelXpath1));
		labelsrow.add(row2xpathelement1);
		labelsrow.add(row2xpathelement2);

		labelsCount = labelsrow.size();

		for (WebElement label : labelsrow) {
			labelTexts = label.getText();
			System.out.println(labelTexts);
		}

		System.out.println(labelsCount);

	}

	public void buttonCount() {
		/*
		 * Find the element by customized xpath and print how many buttons in the page
		 */
		// Assign your locator to buttonXpath variable and use that to locate the
		// element

		// store the buttons count in a variable 'buttonCount'

		// put a loop to print all the button text of web elements stored in button

		// print 'buttonCount' that stored value (count of buttons)

		buttonXpath = By.xpath("//*[@type='button']");
		button = driver.findElements(buttonXpath);
		buttonCount = button.size();

		for (WebElement element : button) {
			buttonText = element.getText();
			System.out.println(buttonText);
		}

		System.out.println(buttonCount);

	}

	public void closeBrowser() {
		// close browser
		driver.quit();

	}

	public static void main(String[] args) {
		CustomizedXpath printoptions = new CustomizedXpath();
		// Add required code
		printoptions.setDriver();
		printoptions.printCount();
		printoptions.printLabels();
		printoptions.buttonCount();
		printoptions.closeBrowser();

	}

}
