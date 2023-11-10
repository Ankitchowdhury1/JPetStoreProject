package Test;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.DogWithIcon;

import org.openqa.selenium.support.PageFactory;
public class DogTestWithIcon

{
	
	WebDriver driver;
	CommonFiles.DogWithIcon addDog;
	
	@BeforeMethod
	public void invokeBrowser()
	{
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        addDog = new DogWithIcon(driver);
	}
	
	
  @Test 
  public void addDog() throws WebDriverException, IOException, InterruptedException  {
	
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
  	  ExtentReports extent = new ExtentReports();
  	  extent.attachReporter(htmlReporter);
  	  ExtentTest test = extent.createTest("Verifying goto Dog With Icon", "Checking goto Dog With Icon");
	  
	  
	  addDog.gotoDogIcon().click();
	  addDog.gotobulldog().click();
	  addDog.gotoMaleAdultBulldog().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotobulldog().click();
	  addDog.gotoFemalePuppyBulldog().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoPoodle().click();
	  addDog.gotoMalePuppyPoodle().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoDalmation().click();
	  addDog.gotoSpotlessMalePuppyDalmation().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoDalmation().click();
	  addDog.gotoSpottedAdultFemaleDalmation().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoGoldenRetriever().click();
	  //addDog.gotoAdultFemaleGoldenRetriever().click();
	  addDog.gotoAddToCartByListForGR().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoChihuahua().click();
	  addDog.gotoAdultMaleChihuahua().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  addDog.gotoDog().click();
	  addDog.gotoChihuahua().click();
	  addDog.gotoAdultFemaleChihuahua().click();
	  addDog.gotoAddToCartFromCart().click();
	  
	  Thread.sleep(1500);
	  
	  driver.close();
	  
	  test.log(Status.INFO, "Test case run successfully");
  	extent.flush();
  	
	  
	  
	  
	  
	  
	  
		
  }
}
