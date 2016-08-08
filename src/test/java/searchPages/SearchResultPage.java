package searchPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SearchResultPage extends BasePage {

    @FindBy(id = "logocont")
    private WebElement smallLogoType;

    @FindBy(css = ".r>a")
    private WebElement links;

    @FindBy(id = "pnnext")
    private WebElement nextPage;

    @FindBy(xpath = ".//*[@id='rso']//div/h3")
    private List<WebElement> titleTextLinksList;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
        wait(smallLogoType);
    }

    /**
     * Create new List with title of the elements that was found. Used Iterator instead cycle "for". and put all
     * elements that was found in the titleText List.
     *
     * @return - List with filled List.
     */
    private List<String> getTitlesLinks() {
        wait(nextPage);
        List<String> titleText = new ArrayList<String>();
        Iterator<WebElement> iterator = titleTextLinksList.iterator();
        while (iterator.hasNext()) {
            WebElement linksTitel = iterator.next();
            String titleTextList = linksTitel.getText();
            titleText.add(titleTextList);
        }
        return titleText;
    }

    /**
     * Check the items in the List on the content searchWord.
     * @param searchWord - any words or phrase by which we want make search
     * @return - isSearchLinksContained;
     */
    public boolean isSearchLinksContained(String searchWord){
        wait(nextPage);
        List<String> titleText = getTitlesLinks();
        boolean isSearchLinksContained = false;
        for (int i = 0; i < titleText.size(); i++) {
            if (titleText.get(i).contains(searchWord)) {
                isSearchLinksContained = true;
            }
        }
        return isSearchLinksContained;
        }

    /**
     * @return - size of the List
     */
    public int NumberOfLinks() {

        return getTitlesLinks().size();
    }

    /**Init new Page.
     * @return - new page
     */
    public SearchResultPage2 clickOnTheNextPageButton(){
        nextPage.click();
        return PageFactory.initElements(driver, SearchResultPage2.class);
    }

}
