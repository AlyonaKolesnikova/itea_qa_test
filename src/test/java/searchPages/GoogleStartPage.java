package searchPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shtrih on 08.08.16.
 */
public class GoogleStartPage extends BasePage {

    public  GoogleStartPage(String url){
        driver.get(url);
        PageFactory.initElements(driver, this);
        wait(searchFIeld);
    }

    @FindBy(id = "lst-ib")
    WebElement searchFIeld;

    @FindBy(id = "sblsbb")
    WebElement searchButton;

    /**
     * @param wordSearch - any words or phrase by which we want make search
     * @return - init new driver for next Page.
     */
    public SearchResultPage putSearchWord(String wordSearch){
        searchFIeld.sendKeys(wordSearch);
        wait(searchButton);
        searchButton.click();
        return PageFactory.initElements(driver, SearchResultPage.class);
    }
}
