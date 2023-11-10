package Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import Category.Birds;
import Category.Cats;
import Category.Dogs;
import Category.Fishs;
import Category.Reptiles;
import CommonFiles.Common;

import CommonFiles.Screenshot;
import CommonFiles.UpdateCart;
import Registration.Registration;
import Registration.SignIn;
import Registration.SignOut;

public class FullWebsiteTest {

	WebDriver driver;
	Common common;
	Registration registration;
	SignIn signIn;
	SignOut signOut;
	Birds birds;
	Cats cats;
	Dogs dogs;
	Fishs fishs;
	Reptiles reptiles;
	Screenshot screenshot;
	UpdateCart updatecart;
	Screenshot invoice;
	
	
	@BeforeClass
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        common = new Common(driver);
        registration = new Registration(driver);
        signIn = new SignIn(driver);
        signOut = new SignOut(driver);
        birds = new Birds(driver);
        cats = new Cats(driver);
        dogs = new Dogs(driver);
        fishs = new Fishs(driver);
        reptiles = new Reptiles(driver);
        screenshot = new Screenshot(driver);
        updatecart = new UpdateCart(driver);
        invoice = new Screenshot(driver);
        
    }
	
	
	@Test
	public void addToCartTest() throws WebDriverException, IOException, InterruptedException {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	  	 ExtentReports extent = new ExtentReports();
	  	  extent.attachReporter(htmlReporter);
	  	  ExtentTest test = extent.createTest("Verifying Full website test", "Checking Full website test");
		
		//create a account on JPetStore website
		signIn.signIn().click();
		Thread.sleep(1500);
		signIn.registerNow().click();
		Thread.sleep(1500);
		registration.enterUsername().sendKeys("sayan2999");
		registration.enterPassword().sendKeys("testpassword1");
		registration.enterRepeatPassword().sendKeys("testpassword1");
		registration.enterFirstName().sendKeys("Johne");
		registration.enterLastName().sendKeys("Doeo");
		registration.enterEmail().sendKeys("test@example1.com");
        registration.enterPhone().sendKeys("1234567898");
        registration.enterAddress1().sendKeys("123 Street");
        registration.enterAddress2().sendKeys("Apt 102");
        registration.enterCity().sendKeys("New York city");
        registration.enterState().sendKeys("NY");
        registration.enterZip().sendKeys("10002");
        registration.enterCountry().sendKeys("USA");
        registration.submitRegistration().click();
		
        Thread.sleep(1500);
		//Signin to the JPetStore website
		signIn.signIn().click();
		signIn.enterUsername().sendKeys("sayan2567");;
		signIn.enterPassword().clear();
		signIn.enterPassword().sendKeys("testpassword1");
		signIn.clickLogin().click();
		
		Thread.sleep(1500);
		
		//add fish items
		fishs.gotoFish().click();
		fishs.gotoAngelfish().click();
		fishs.gotoviewSmallAngelfish().click();
		common.addToCart().click();
		
		Thread.sleep(1500);
		//add dog item
		dogs.gotoDog().click();
		dogs.gotoBulldog().click();
		dogs.gotoFemalePuppyBulldog().click();
		common.addToCart().click();
		
		Thread.sleep(1500);
		//add cat 
		cats.gotoCats().click();
		cats.gotoPersian().click();
		cats.gotoAdultMalePersian().click();
		common.addToCart().click();
		
		Thread.sleep(1500);
		//add reptiles
		reptiles.gotoReptile().click();
		reptiles.gotoRattleSnake().click();
		reptiles.gotoVenomlessRattleSnake().click();
		common.addToCart().click();
		
		Thread.sleep(1500);
		//add birds
		birds.gotoBird().click();
		birds.gotoAmazonParrot().click();
		birds.gotoAdultMaleAmazonParrot().click();
		common.addToCart().click();
		
		Thread.sleep(1500);

		//updatecart.updatebox().click();
//		updatecart.updatebox().clear();
//		updatecart.updatebox().sendKeys("4");
		
		driver.findElement(By.xpath("//input[@name='EST-2']")).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@name='EST-2']")).sendKeys("4");
		
		updatecart.updateButton().click();
		Thread.sleep(1500);
		
		//proceed to checkout
		common.proceedToCheckout().click();
		Thread.sleep(1500);
		//continue button click
		common.continueButton().click();
		Thread.sleep(1500);
		//confirm button click
		common.confirmButton().click();
		Thread.sleep(1500);
		//take screenshot
		
		screenshot.fullScreenShot("invoice");
		
		Thread.sleep(1500);
		
		signOut.signOut().click();
		
		Thread.sleep(1500);
		
		driver.close();
		
		test.log(Status.INFO, "Test case run successfully");
    	extent.flush();
    	
	}
	
//	public void screenShot() throws IOException, WebDriverException
//	{
//		//Screenshot code
//		File src=null;
//		try {
//			src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		} catch (WebDriverException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Files.copy(src, new File("./screenshot/"+"Page-"+System.currentTimeMillis()+".png"));
//	}
	
}
