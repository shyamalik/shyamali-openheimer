package com.openheimer.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By cashDispensed = By.xpath("//div[@class = 'display-4 font-weight-bold']");

    private By dispenseNowLink = By.xpath("//a[@href='dispense']");

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void clickDispenseNowButton(){
        driver.findElement(dispenseNowLink).click();
    }

    public String getDispenseLinkText(){
        return driver.findElement(dispenseNowLink).getText();
    }

    public String getCashDispensed(){
        return driver.findElement(cashDispensed).getText();
    }

    public String getDispenseNowButtonColor() {
        return driver.findElement(dispenseNowLink).getCssValue("background-color");
    }

}

