package grpid4.step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import grpid4.pages.ResultsPage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class reviewByOptions {

    private ResultsPage resultsPage = new ResultsPage();
    public static String  reviewtype;



    @And("^I apply filter \"([^\"]*)\" on search result$")
    public void iApplyFilterOnSearchResult(String filterValue) throws Throwable {
        resultsPage.filterByOption(filterValue);
    }

    @Then("^I should see all products \"([^\"]*)\" are filtered \"([^\"]*)\"$")
    public void iShouldSeeAllProductsAreFiltered(String filter, String filterValue) throws Throwable {

        //review filter

        if (filter.equalsIgnoreCase("review")) {
            List<Double> actual = resultsPage.getAllRatings();
            assertThat("List is storing wrong value",
                    actual, everyItem(greaterThanOrEqualTo(Double.parseDouble(filterValue))));
        }//if ends

        //range filter

        if (filter.equalsIgnoreCase("range")) {
            List<Double> actual = resultsPage.getAllProductsPrices();
            List<String> rangeList = Arrays.asList(filterValue.split("-"));
            Double min = Double.parseDouble(rangeList.get(0));
            Double max = Double.parseDouble(rangeList.get(1));
            assertThat(actual, everyItem(is(both(greaterThanOrEqualTo(min)).and(lessThanOrEqualTo(max)))));
        }//if ends

        //category filter

        if (filter.equalsIgnoreCase("category")) {
            List<String> actual = resultsPage.getAllProductNames();
            assertThat("List is storing wrong value",
                    actual, everyItem(containsString("Running")));
            System.out.println("The Product Names are"+ actual);
        }//if ends
    }


}//class


