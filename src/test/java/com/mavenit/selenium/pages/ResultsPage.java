package com.mavenit.selenium.pages;

import com.mavenit.selenium.Hooks;
import com.mavenit.selenium.driver.DriverFactory;
import com.mavenit.selenium.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ResultsPage extends DriverFactory {

    public List<String> getAllProductNames(){
        List<String> productNamesList = new ArrayList<>();

        List<WebElement> productWebElements = isProductsAvailable();

        for (WebElement indProduct : productWebElements) {
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;
    }

    public String getSearchTitle(){
        return driver.findElement(By.className("search-title__term")).getText();

    }


    public String selectAnyProduct(){
        List<WebElement> productWebElements = isProductsAvailable();
       int productSize = productWebElements.size();

       int randomNumber = new Helpers().randomNumberGenerator(productSize);

        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();

        return selectedProductName;

    }

    private List<WebElement> isProductsAvailable(){
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(productWebElements.size()==0){
            // fail("Zero products found .....");
            throw new RuntimeException("Zero products found .....");
        }
        return productWebElements;
    }





}
