package seleniumPractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).sendKeys("java");

//		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']"));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='sbl1']"));

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("javascript")) {
				list.get(i).click();
				break;
			}

		}
	}

}
