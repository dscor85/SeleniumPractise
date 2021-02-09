package seleniumPractise;

//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DownloadFileConcept {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chome\\chromedriver.exe");

		// ChromeOptions is a class
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefers = new HashMap<String, Object>();

		prefers.put("profile.deafult_content_settings.pupups", 0);
		prefers.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefers);

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

//		driver = new ChromeDriver(cap);

	}

	
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		Thread.sleep(2000);
		
		File listOfFiles[] = folder.listFiles();
		
//		Assert.assertEquals(listOfFiles.length, is(not(0)));
		
		Assert.assertTrue(listOfFiles.length>0);
		
		
		for(File file:listOfFiles) {
			Assert.assertTrue(file.length()>0);
		}
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		for(File file : folder.listFiles()){
			file.delete();
		}
				
		folder.delete();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
