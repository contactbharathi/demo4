package grpid4.step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import grpid4.pages.BasketPage;
import grpid4.pages.ResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RemoveFromBasket {

    private BasketPage basketPage = new BasketPage();

    @And("^all the products relevant should be displayed$")
    public void allTheProductsRelevantShouldBeDisplayed() throws Throwable {

    }

    @And("^remove the product$")
    public void removeTheProduct() throws Throwable {
        basketPage.removeProduct();
    }

    @Then("^the product should not be in the basket$")
    public void theProductShouldNotBeInTheBasket() throws Throwable {

        String actual = basketPage.getRemovedMsgText();
        assertThat(actual,containsString(ResultsPage.selectedProduct + " was removed from your trolley"));

    }
}
