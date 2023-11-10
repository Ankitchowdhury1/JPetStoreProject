package DefectTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Registration.MyAccount;
import Registration.SignIn;
import Registration.SignOut;

public class CheckAccountUpdationTest {
	
	static WebDriver driver;
	MyAccount editAccount;
	SignIn signEdit;
	SignOut nowLogout;
	
	
	@BeforeMethod
	public void invokeBrowser()
	{
		
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        editAccount = new MyAccount(driver);
        signEdit = new SignIn(driver);
        nowLogout=new SignOut(driver);
	}
	
	
  @Test
  public void f() throws InterruptedException {
	  
	  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
  	ExtentReports extent = new ExtentReports();
  	extent.attachReporter(htmlReporter);
  	ExtentTest test = extent.createTest("Verifying Check Account Updation Test", "Checking Check Account Updation Test");
	  
	  signEdit.signIn().click();
	  Thread.sleep(1500);
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  signEdit.enterPassword().clear();
	  Thread.sleep(1500);
	  signEdit.enterPassword().sendKeys("7488099532");
	  Thread.sleep(1500);
	  signEdit.clickLogin().click();
	  
	  Thread.sleep(1500);
	  editAccount.gotoMyAccount().click();
//	  editAccount.changePassword().sendKeys("12345");
//	  editAccount.resetPassword().sendKeys("12345");
	  //editAccount.changeFirstName().click();
	  Thread.sleep(1500);
	  editAccount.changeFirstName().clear();
	  editAccount.changeFirstName().sendKeys("sayan");
	  Thread.sleep(1500);
	  editAccount.changeLastName().clear();
	  editAccount.changeLastName().sendKeys("king");
	  Thread.sleep(1500);
	  editAccount.changeEmail().clear();
	  editAccount.changeEmail().sendKeys("akashkrrsingh5862@gmail.com");
	  Thread.sleep(1500);
	  editAccount.changePhone().clear();
	  editAccount.changePhone().sendKeys("9934740465");
	  Thread.sleep(1500);
	  editAccount.changeAddress1().clear();
	  editAccount.changeAddress1().sendKeys("Itc");
	  Thread.sleep(1500);
	  editAccount.changeAddress2().clear();
	  editAccount.changeAddress2().sendKeys("cox town");
	  Thread.sleep(1500);
	  editAccount.changeCity().clear();
	  editAccount.changeCity().sendKeys("Bengaluru");
	  Thread.sleep(1500);
	  editAccount.changeState().clear();
	  editAccount.changeState().sendKeys("karnataka");
	  Thread.sleep(1500);
	  editAccount.changeCountry().clear();
	  editAccount.changeCountry().sendKeys("india");
	  Thread.sleep(1500);
	  editAccount.changeZip().clear();
	  editAccount.changeZip().sendKeys("560002");
	  Thread.sleep(1500);
	  
	  editAccount.changeLanguagePreference().click();
	  Thread.sleep(1500);
	  editAccount.changeFavouriteCategory().click();
	  Thread.sleep(1500);

	  editAccount.changeSave().click();
	  Thread.sleep(1500);
	  
	  nowLogout.signOut().click();
	  
//	  signEdit.signIn().click();
//	  signEdit.enterUsername().sendKeys("Pushpak123");
//	  
//	  signEdit.enterPassword().clear();
//	  signEdit.enterPassword().sendKeys("12345");
//	  signEdit.clickLogin().click();
	  
	  //logging in with the old password 
	  Thread.sleep(1500);
	  signEdit.signIn().click();
	  Thread.sleep(1500);
	  signEdit.enterUsername().sendKeys("Pushpak123");
	  
	  signEdit.enterPassword().clear();
	  Thread.sleep(1500);
	  signEdit.enterPassword().sendKeys("7488099532");
	  Thread.sleep(1500);
	  signEdit.clickLogin().click();
	  Thread.sleep(1500);
	  
	  editAccount.gotoMyAccount().click();
	  Thread.sleep(1500);
	  
	  //take a screenshot to verify
	  
	  driver.close();
	  
	  test.log(Status.INFO, "Test case run successfully");
	  	extent.flush();
	  
  }
}
