package seleniumPractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_Part2 {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		// make sure the html tag is select
	
		String month_xpath = "//select[@id='month']//option";
		String year_xpath = "//select[@id='year']//option";
		String day_xpath = "//select[@id='day']//option";
		
		selectDropDownValue(month_xpath, "June");
		selectDropDownValue(year_xpath, "1990");
		selectDropDownValue(day_xpath, "10");
	}

	public static void selectDropDownValue(String xpathValue, String value) {
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));

		for (int i = 0; i < monthList.size(); i++) {
			System.out.println(monthList.get(i).getText());
			if (monthList.get(i).getText().equals(value)) {
				monthList.get(i).click();
				break;
			}
		}

	}

}
