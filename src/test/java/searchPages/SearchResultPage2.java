package searchPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SearchResultPage2  extends BasePage {

    @FindBy(id = "pnprev")
    WebElement identifierForNextPage;

    @FindBy (xpath = ".//*[@id='rso']/div/div")
    private List<WebElement> titleTextWebElementListSecondPage;

    public SearchResultPage2() {
        PageFactory.initElements(driver, this);
        wait(identifierForNextPage);
    }

    private List<String> getTitlesLinksSecondPage() {
        wait(identifierForNextPage);
        List<String> titleTextSecondPage = new ArrayList<String>();
        Iterator<WebElement> iterator = titleTextWebElementListSecondPage.iterator();
        while (iterator.hasNext()) {
            WebElement linksTitleSecondPage = iterator.next();
            String titleTextListSecondPage = linksTitleSecondPage.getText();
            titleTextSecondPage.add(titleTextListSecondPage);
        }
        return titleTextSecondPage;
    }

    /**
     * Check the items in the List on the content searchWord.
     * @param searchWord - any words or phrase by which we want make search
     * @return - isSearchLinksContained;
     */
    public boolean isSearchLinksContained(String searchWord){
        wait(identifierForNextPage);
        List<String> titleText = getTitlesLinksSecondPage();
        boolean isSearchLinksContainedSecondPage = false;
        for (int i = 0; i < titleText.size(); i++) {
            if (titleText.get(i).contains(searchWord)) {
                isSearchLinksContainedSecondPage = true;
            }
        }
        return isSearchLinksContainedSecondPage;
    }

    /**
     * @return - size of the List
     */
    public int NumberOfLinksSecondPage() {

        return getTitlesLinksSecondPage().size();
    }

}
