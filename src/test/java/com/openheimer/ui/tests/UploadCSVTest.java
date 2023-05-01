package com.openheimer.ui.tests;

import com.openheimer.ui.pages.UploadCSVPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;

public class UploadCSVTest extends BaseTest {

    @Test
    public void uploadCsvFileTest(){
        UploadCSVPage uploadCSVPage = new UploadCSVPage(driver);
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\EmployeeTax - Sheet1.csv";
        uploadCSVPage.uploadFile(filePath);
        uploadCSVPage.clickRefreshTaxButton();
        Assert.assertEquals(uploadCSVPage.getLastRowNatId(),"020-$$$$$$$");

    }

}
