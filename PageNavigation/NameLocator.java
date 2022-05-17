import org.openqa.selenium.WebDriver;

public class NameLocator {
	static String page1, page2, page3, page4, page5, baseUrl;
	static WebDriver driver;

	public WebDriver setupDriver() {
		/* Replace this comment by the code statement to get the driver */
		
		driver = DriverSetup.getWebDriver();
		return driver;
	}

	public void navigate1() {
		/* Replace this comment by the code statement to navigate to baseUrl */
		baseUrl = "https://www.selenium.dev/";
		driver.get(baseUrl);
		
	}

	public void getPageTitle1() {
		/*
		 * Replace this comment by the code statement to get page title of
		 * "https://selenium.dev/"
		 */
		/* Assign the page title to variable 'page1' */
		
		page1 = driver.getTitle();

	}

	public void navigate2() {
		/*
		 * Replace this comment by the code statement to navigate to
		 * https://www.google.co.in/
		 */
		
		driver.get("https://www.google.co.in/");
	}

	public void getPageTitle2() {
		/*
		 * Replace this comment by the code statement to get page title of
		 * https://www.google.co.in/
		 */
		/* Assign the page title to variable 'page2' */
		
		page2 = driver.getTitle();

	}

	public void navigateBack() {
		/* Replace this comment by the code statement to navigate back */
		driver.navigate().back();
	}

	public void getPageTitle3() {
		/*
		 * Replace this comment by the code statement to get page title of backed page
		 */
		/* Assign the page title to variable 'page3' */
		
		page3 = driver.getTitle();

	}

	public void navigateForward() {
		/* Replace this comment by the code statement to navigate forward */
		
		driver.navigate().forward();
	}

	public void getPageTitle4() {
		/*
		 * Replace this comment by the code statement to get page title of the forwarded
		 * page
		 */
		/* Assign the page title to variable 'page4' */
		
		page4 = driver.getTitle();

	}

	public void refreshPage() {
		/* Replace this comment by the code statement to refresh the page */
		driver.navigate().refresh();
	}

	public void getPageTitle5() {
		/*
		 * Replace this comment by the code statement to get page title of refreshed
		 * page
		 */
		/* Assign the page title to variable 'page5' */
		
		page5 = driver.getTitle();

	}

	public static void main(String[] args) {
		NameLocator nameLocator = new NameLocator();
		
		// Implement code here
		driver = nameLocator.setupDriver();
		nameLocator.navigate1();
		nameLocator.getPageTitle1();
		nameLocator.navigate2();
		nameLocator.getPageTitle2();
		nameLocator.navigateBack();
		nameLocator.getPageTitle3();
		nameLocator.navigateForward();
		nameLocator.getPageTitle4();
		nameLocator.refreshPage();
		nameLocator.getPageTitle5();
		
	}

}
