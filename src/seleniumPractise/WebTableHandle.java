package seleniumPractise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		// driver.manage().window().maximize();

		// /html/body/div[6]/div[1]/div[1]/div[3]/div/table/tbody/tr[2]/td[1] ---> FF
		// //*[@id="customers"]/tbody/tr[2]/td[1] -- chrome ---> Chrom
		// //*[@id="customers"]/tbody/tr[4]/td[1]
		// /html/body/div[6]/div[1]/div[1]/div[3]/div/table/tbody/tr[2]/td[1] ---> Chrom
		// full xpath

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

		int rowcount = rows.size();

		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[1]";

		for (int i = 2; i <= rowcount; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

			if (element.getText().equals("Island Trading")) {
				System.out.println("company name: " + element.getText() + " is found" + "at position : " + (i - 1));
				break;
			}

		}

		System.out.println("***************");

		// *[@id="customers"]/tbody/tr[2]/td[2]

		String afterXpathContact = "]/td[2]";
		for (int i = 2; i <= rowcount; i++) {
			String actualXpath = beforeXpath + i + afterXpathContact;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());

			if (element.getText().equals("Island Trading")) {
				System.out.println("company name: " + element.getText() + " is found" + " at position : " + (i - 1));
				break;
			}

		}

		// handle WebTable Columns
		// *[@id="customers"]/tbody/tr[1]/th[1]
		// *[@id="customers"]/tbody/tr[1]/th[2]
		// *[@id="customers"]/tbody/tr[1]/th[3]
		System.out.println("***************");
		String colBeforeXpath = "//*[@id='customers']/tbody/tr[1]/th[";
		String colAfterXpath = "]";
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int colCount = cols.size();

		for (int j = 1; j < colCount; j++) {
			String colActualXpath = colBeforeXpath + j + colAfterXpath;
			WebElement element = driver.findElement(By.xpath(colActualXpath));
			System.out.println(element.getText());

		}

		driver.quit();
	}

}
