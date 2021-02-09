package seleniumPractise;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderSelectTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("dpamrocks@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test12345");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.switchTo().frame("mainpanel");

		String date = "25-September-2000";
		String[] dateArr = date.split("-");

		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];

		WebElement elementMonth = driver.findElement(By.name("scltMonth"));
		WebElement elementYear = driver.findElement(By.name("scltYear"));

		selectValueFromDropDown(elementMonth, month);
		selectValueFromDropDown(elementYear, year);

		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// *[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]

		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";

		final int totalWeekdays = 7;
		boolean flag = false;
		String dayVal;

		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekdays; colNum++) {

				try {
					dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}

				if (dayVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).click();
					flag = true;
					break;
				}

			}
			if (flag) {
				break;
			}

		}

	}

	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

}
