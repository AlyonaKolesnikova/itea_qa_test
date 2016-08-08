package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import searchPages.GoogleStartPage;
import searchPages.SearchResultPage;

/**
 * Created by shtrih on 08.08.16.
 */
public class GoogleSearchTest {
    final static String url = "https://www.google.com.ua";
    final static String searchWord = "ITEA";
    final static int numberOfLinksOnTheFirstPage = 8;
    final static int numberOfLinksOnTheSecondtPage = 10;

    @Test
    public void GoogleSearchPage(){
        GoogleStartPage googleStartPage = new GoogleStartPage(url);
        Assert.assertNotNull(googleStartPage, "Search page is not loaded");
        SearchResultPage searchResult = googleStartPage.putSearchWord(searchWord);
        Assert.assertNotNull(searchResult, "SearchPage is not loaded");
        Assert.assertTrue(searchResult.isSearchLinksContained(searchWord), "Each item from results list not contains searchWord");
        Assert.assertEquals(searchResult.NumberOfLinks(), numberOfLinksOnTheFirstPage, "Actual results are not equals numberOfLinksOnTheFirstPage");
        System.out.println(searchResult.NumberOfLinks());
    }
}
