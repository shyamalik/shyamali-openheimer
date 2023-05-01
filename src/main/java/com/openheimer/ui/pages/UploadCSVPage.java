package com.openheimer.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadCSVPage {

    private By BrowseFileButton = By.xpath("//*[@id='contents']/div[1]/div[2]/input");

    private By RefreshTaxButton = By.xpath("//div[@id='contents']/button[1]");

    private By LastRowNatId = By.xpath("//tr[last()]/td[1]");
    WebDriver driver;

    public UploadCSVPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRefreshTaxButton() {
        driver.findElement(RefreshTaxButton).click();
    }

    public WebElement getBrowserButton() {
        return driver.findElement(BrowseFileButton);
    }

    public void uploadFile(String path) {
        getBrowserButton().sendKeys(path);
    }

    public String getLastRowNatId() {
        return driver.findElement(LastRowNatId).getText();
    }

    public WebElement getLastRowNatIdElement() {
        return driver.findElement(LastRowNatId);
    }
}
