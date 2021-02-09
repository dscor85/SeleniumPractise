package seleniumPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) {

//HtmlUnitDriver is not available in selenium 3.x version
		//1.very fast
		//not suitable for Actiosn class -- user actions, mouse movement, double click, drag drop
		//also called Ghost Driver/head less browser
		
		//Headless browsers
		//--PhantomjS - javaSriptS
		
		WebDriver driver = new HtmlUnitDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
		
		
	}

}
