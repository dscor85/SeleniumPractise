package seleniumPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderWithJS {


	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		
		
		WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		String dateVal = "11-02-2021";
		
		selectDateByJS(driver, date, dateVal);
		
		System.out.println("dateSelected");
		
		
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}

}
