package searchPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver = new FirefoxDriver();

    /**
     * @param element - will be wait unique element in the page before doing next step/
     */
    public void wait(WebElement element){
        WebDriverWait waitTime = new WebDriverWait(driver, 30);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
    }

}
