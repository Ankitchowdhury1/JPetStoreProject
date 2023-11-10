package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFiles.ProductPage;

import org.testng.Assert;
//import io.github.bonigarcia.wdm.WebDriverManager;
public class PetStoreTest {
    WebDriver driver;
    ProductPage productPage;
//    @BeforeTest
//    public void setUp() {
//        //WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01");
//        productPage = new ProductPage(driver);
//    }
    @Test
    public void testAngelfishAvailability() {
        String largeAngelfishStatus = productPage.getLargeAngelfishStatus();
        String smallAngelfishStatus = productPage.getSmallAngelfishStatus();
        // Check if the Large Angelfish is out of stock
        
        System.out.println(largeAngelfishStatus);
//        if (largeAngelfishStatus.contains("Back ordered.")) {
//            // Large Angelfish is out of stock, an error message should be displayed
//            Assert.assertTrue(driver.getPageSource().contains("Large Angelfish is out of stock."));
//        }
//        // Check if the Small Angelfish is in stock
//        if (smallAngelfishStatus.contains("8871 in stock.")) {
//            // Small Angelfish is in stock, try to add it to the cart
//            productPage.clickAddToCartForSmallAngelfish();
//            // Verify if the item was added to the cart successfully
//            Assert.assertTrue(driver.getPageSource().contains("Small Angelfish added to your cart."));
//        }
    }
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
}