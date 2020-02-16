package com.mavenit.selenium.steps_definations;

import com.mavenit.selenium.pages.HomePage;
import com.mavenit.selenium.pages.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.getCurrentUrl();
        assertThat(actual, endsWith("co.uk/"));
    }

    @When("^I search for product nike$")
    public void i_search_for_product_nike() {
        homePage.doSearch("nike");
    }

    @Then("^I should be able to see nike product$")
    public void i_should_be_able_to_see_nike_product() {
        String actaulTitle = resultsPage.getSearchTitle();
        List<String> allProductNames = resultsPage.getAllProductNames();

        assertThat(actaulTitle, is(equalToIgnoringWhiteSpace("nike")));
        for (String item : allProductNames) {
            assertThat(item, containsString("nike"));
        }
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void iSearchForProduct(String item){
        homePage.doSearch(item);

    }
}
