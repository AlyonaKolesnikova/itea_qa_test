package searchPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by shtrih on 08.08.16.
 */
public class BasePage {
    public static WebDriver driver = new FirefoxDriver();

    public void wait(WebElement element){
        WebDriverWait waitTime = new WebDriverWait(driver, 30);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
    }

}
