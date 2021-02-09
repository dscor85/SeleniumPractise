package seleniumPractise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/");

		// links -- //a href
		// images -- //img href<www.ddd.com>
		// (Hypertext REFerence) The HTML code used to create a link to another page

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));

		System.out.println("full size-->" + linksList.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		// iterate linkslist : exclude all the links/images - does not have href
		// attribute
		for (int i = 0; i < linksList.size(); i++) {
			if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));

			}
		}

		System.out.println("size of active links & images--->" + activeLinks.size());

	
		//check the href url, with httpconnection api
		
		for(int j=0;j<activeLinks.size();j++) {
			
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();//ok
			connection.disconnect();
			
			System.out.println(activeLinks.get(j).getAttribute("href") + "-->" + response);
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
