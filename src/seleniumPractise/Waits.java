package seleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("www. ");
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		
		sendKeys(driver, firstName, 10, "Tom");
		
		
		
		WebElement forgotAccount = driver.findElement(By.linkText("Forgotten account?"));
		clickOn(driver, forgotAccount, 5);
		

	}
	
	//1. available with WebDriverWait with some expected condtions
	//2. specific to element
	//3. dynamic in nature
	
	//4. never use impli wait and expli wait together cuz selenium WD will wait for the element first cuz of
	//implicit wait and den explicit wait will be applied 
	//hence total sysc time will be increased for each element
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		
		//creating object of WebDriverWait class
		//ExpectedConditions is a class 
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		
		new WebDriverWait(driver, timeout)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		
	}
	

}
