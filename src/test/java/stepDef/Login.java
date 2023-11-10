package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Registration.SignIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertTrue;

public class Login {
	
		//CucumberLogin login;
	   	WebDriver driver;

	    @Given("I am on the login page")
	    public void iAmOnTheLoginPage() {
	    	driver = new ChromeDriver();
	        driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	        //login = new CucumberLogin(driver);
	    }

	    @When("I enter valid username {string} and password {string}")
	    public void iEnterValidCredentials(String username, String password) {
	        driver.findElement(By.xpath("//input[@id='stripes-551914828']")).sendKeys("ank1234");
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
	        
//	    	login.username().sendKeys(username);
//	    	login.password().sendKeys(password);
	    }

//	    @When("I enter invalid username {string} and invalid password {string}")
//	    public void iEnterInvalidCredentials(String username, String password) {
//	    	WebElement usernameField = driver.findElement(By.xpath("//input[@id='stripes-551914828']"));
//	        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
//	        usernameField.sendKeys(username);
//	        passwordField.sendKeys(password);
//	    	
////	    	login.username().sendKeys(username);
////	    	login.password().sendKeys(password);
//	    }

	    

	    @When("I click the login button")
	    public void iClickLoginButton() {
	        WebElement loginButton = driver.findElement(By.xpath("//input[@name='signon']"));
	        loginButton.click();
	    	//login.submit();
	    	
	    }

	    @Then("I should be logged in successfully")
	    public void iShouldBeLoggedInSuccessfully() {
	        
	        String currentURL = driver.getCurrentUrl();
	        assertTrue(currentURL.contains("successful")); 
	    }

	    @Then("I should see an error message")
	    public void iShouldSeeErrorMessage() {
	        WebElement errorMessage = driver.findElement(By.id("error-message")); 
	        assertTrue(errorMessage.isDisplayed());
	    }

	    

	    @And("close browser")
	    public void closeBrowser() {
	        driver.quit();
	    }
	}

	

