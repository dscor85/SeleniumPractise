package seleniumPractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);

//		Actions action = new Actions(driver);
//
//		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
//		.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();

		 WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
		 WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
		//
		// action.dragAndDrop(drag, drop).build().perform();
		
		dragAndDrop(driver, drag, drop);

		System.out.println("success");

	}

	public static void dragAndDrop(WebDriver driver, WebElement elementDrag, WebElement elementDrop) {
		Actions action = new Actions(driver);
		action.dragAndDrop(elementDrag, elementDrop).build().perform();

	}

}
