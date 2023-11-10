package CommonFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ProductPage {
    private WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getLargeAngelfishStatus() {
        WebElement statusElement = driver.findElement(By.xpath("//td[normalize-space()='Back ordered.']"));
        return statusElement.getText();
    }
    public String getSmallAngelfishStatus() {
        WebElement statusElement = driver.findElement(By.xpath("//td[normalize-space()='8871 in stock.']"));
        return statusElement.getText();
    }
    public void clickAddToCartForSmallAngelfish() {
        WebElement addToCartButton = driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));
        addToCartButton.click();
    }
}
