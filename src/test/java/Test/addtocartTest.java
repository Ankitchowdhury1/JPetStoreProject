package Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFiles.Common;
import CommonFiles.JPetSearch;
import CommonFiles.Screenshot;
import Registration.SignIn;


public class addtocartTest {

	WebDriver driver;
	SignIn signIn;
    JPetSearch search;
    Screenshot searchresult;
    Common add;
    
    @BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        search = new JPetSearch(driver);
        searchresult = new Screenshot(driver);
        add = new Common(driver);
        signIn = new SignIn(driver);
    }
    
    @Test
    public void testUserSearch() throws IOException, InterruptedException {
    	
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    	ExtentReports extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	ExtentTest test = extent.createTest("Verifying Add to cart", "Checking the Cart");
    	
    	
    	signIn.signIn().click();
		signIn.enterUsername().sendKeys("sayan2567");
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("testpassword1");
		signIn.clickLogin().click();
		
		Thread.sleep(1500);
		
    	search.searchResult().sendKeys("Fish", Keys.ENTER);
    	
    	Thread.sleep(1500);
    	
    	//searchresult.screenShot();
    	driver.findElement(By.xpath("//a[normalize-space()='Fresh Water fish from China']")).click();
    	
    	Thread.sleep(1500);
    	
    	driver.findElement(By.xpath("//a[normalize-space()='EST-21']")).click();
    	
    	Thread.sleep(1500);
    	
    	add.addToCart().click();
    	
    	Thread.sleep(1500);
    	
    	driver.close();
    	
    	test.log(Status.INFO, "Test case run successfully");
    	extent.flush();
    	
    }
    
	
}
