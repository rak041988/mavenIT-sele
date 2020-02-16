package com.mavenit.selenium.pages;

import com.mavenit.selenium.Hooks;
import com.mavenit.selenium.driver.DriverFactory;
import org.openqa.selenium.By;

public class TrolleyPage extends DriverFactory {

    public void addToTrolley() {
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();
    }


    public void goToTrolley() {
        driver.findElement(By.cssSelector(".xs-row a[data-test='component-att-button-basket']")).click();
    }

    public String getProductInTrolley() {
        return driver.findElement(By.cssSelector(".ProductCard__content__9U9b1.xsHidden.lgFlex")).getText();
    }
}
