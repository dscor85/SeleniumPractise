package seleniumPractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		// make sure the html tag is select
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		String dob = "10-Oct-1990";
		String[] dobArr = dob.split("-");

		selectValueFromDropDown(day, dobArr[0]);
		selectValueFromDropDown(month, dobArr[1]);
		selectValueFromDropDown(year, dobArr[2]);

		Select select = new Select(year);
		// IMP
		List<WebElement> listDays = select.getOptions();
		listDays.size();

		for (int i = 0; i < listDays.size(); i++) {
			String dayVal = listDays.get(i).getText();

			if (dayVal.equals("15")) {
				listDays.get(i).click();
				break;
			}
		}

	}

	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

}

// select.isMultiple();
// select.deselectAll();
// select.deselectByIndex(0);
// select.deselectByValue(month);
// select.deselectByVisibleText(month);
