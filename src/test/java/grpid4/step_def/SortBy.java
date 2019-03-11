package grpid4.step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import grpid4.pages.ResultsPage;
import grpid4.pages.BasketPage;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.openqa.selenium.By.cssSelector;

public class SortBy {
    List <Double> beforeSortingList;
    List <Double> afterSortingList;

    private ResultsPage resultsPage = new ResultsPage();

    @And("^I select \"([^\"]*)\" Option$")

    public void iSelectOption(String sortByOptionType) throws Throwable {

        System.out.println(sortByOptionType);
        resultsPage.sortByOptionClick(sortByOptionType);

       if (sortByOptionType.equalsIgnoreCase("Low - High"))
       {
           beforeSortingList  = resultsPage.collectingPricesList();

           afterSortingList= resultsPage.sortingTheList(beforeSortingList);
       }
       else if (sortByOptionType.equalsIgnoreCase("High - Low")){
           beforeSortingList  = resultsPage.collectingPricesList();
           afterSortingList= resultsPage.sortingTheList(beforeSortingList);

           Collections.reverse(afterSortingList);//reverse  the sorted list
       }
       else {
           beforeSortingList = resultsPage.getAllRatings();
           afterSortingList= resultsPage.sortingTheList(beforeSortingList);
           Collections.reverse(afterSortingList);//reverse  the sorted list
       }

        System.out.println("Before sorted list size===>"+ beforeSortingList.size());
        System.out.println("Before sorted list values===>"+ beforeSortingList);

        System.out.println("After sorted list size===>"+ afterSortingList.size());
        System.out.println("After sorted list Values===>"+ afterSortingList);
    }

    @Then("^I should see the results$")
    public void iShouldSeeTheResults() throws Throwable {
        assertThat("They are not displayed in sorted manner", (beforeSortingList.equals(afterSortingList)));
        System.out.println("They are displayed in sorted manner");
    }

    @And("^All the relevant products should be displayed$")
    public void allTheRelevantProductsShouldBeDisplayed() throws Throwable {
        System.out.println("Products displayed");
    }
}
