package grpid4.step_def;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import grpid4.pages.BasketPage;
import grpid4.pages.HeaderPage;
import grpid4.pages.ResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class BasketSteps{


        private ResultsPage resultsPage=new ResultsPage();
        private BasketPage basketPage = new BasketPage();

    @And("^I select any product$")
    public void iSelectAnyProduct() throws Throwable {
        resultsPage.selectAnyProduct();


    }

    @And("^I add the product to the basket$")
    public void iAddTheProductToTheBasket() throws Throwable {
        basketPage.addbasket();


    }

    @Then("^the product should be in the basket$")
    public void theProductShouldBeInTheBasket() throws Throwable {
        String actual = basketPage.productInBasketCheck();
        assertThat(actual, is(equalToIgnoringCase(ResultsPage.selectedProduct)));

    }


}
