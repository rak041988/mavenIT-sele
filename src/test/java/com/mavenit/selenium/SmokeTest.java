package com.mavenit.selenium;

import com.mavenit.selenium.pages.HomePage;
import com.mavenit.selenium.pages.ResultsPage;
import com.mavenit.selenium.pages.TrolleyPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

public class SmokeTest {

    private HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    private TrolleyPage trolleyPage= new TrolleyPage();

    @Test
    public void searchTest() {
        String searchTerm="puma";
        homePage.doSearch(searchTerm);
        assertThat(homePage.getCurrentUrl(), endsWith(searchTerm));
        List<String> actualProductList = resultsPage.getAllProductNames();
        for (String product: actualProductList){
            assertThat(product,containsString(searchTerm));
        }
        String actualTitle = resultsPage.getSearchTitle();
        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
    }

    @Test
    public void basketTest() {
        homePage.doSearch("nike");
        String selectedProductName =resultsPage.selectAnyProduct();
        trolleyPage.addToTrolley();
        trolleyPage.goToTrolley();
        String actual = trolleyPage.getProductInTrolley();
        assertThat(actual, is(equalToIgnoringCase(selectedProductName)));
    }
}

























