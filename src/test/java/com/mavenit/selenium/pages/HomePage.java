package com.mavenit.selenium.pages;

import com.mavenit.selenium.Hooks;
import com.mavenit.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends DriverFactory {

    public void doSearch(String searchTerm) {
        driver.findElement(By.id("searchTerm"))
                .sendKeys(searchTerm);

        driver.findElement(By.id("searchTerm"))
                .sendKeys(Keys.ENTER);

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();

    }
}
