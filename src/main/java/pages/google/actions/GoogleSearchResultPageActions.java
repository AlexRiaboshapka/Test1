package pages.google.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import org.testng.Assert;
import pages.google.locators.GoogleSearchResultPageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class GoogleSearchResultPageActions extends GoogleSearchResultPageLocators {
    private int amountOfSearchResults;
    private boolean testPassed = false;

    @Step
    public void countSearchResults() {
        amountOfSearchResults = $$(byXpath(searchResults)).size();
    }

    public void checkEachSearchResult(String text) {
        CustomLogger.logger.info(text);
        for (int i = 1; i <= amountOfSearchResults; i++) {
            if ($(byXpath(searchResults + "[" + i + "]")).getText().equals(text)) {
                testPassed = true;
                break;
            }
        }
        Assert.assertTrue(testPassed, "Text not found: " + text);
    }
}
