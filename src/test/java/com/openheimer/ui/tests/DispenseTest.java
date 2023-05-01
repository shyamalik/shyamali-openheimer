package com.openheimer.ui.tests;

import com.openheimer.ui.pages.HomePage;
import com.openheimer.ui.pages.UploadCSVPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLOutput;

public class DispenseTest extends BaseTest {

    @Test
    public void DispenseButtonColorTest(){
        HomePage homePage =  new HomePage(driver);
        Assert.assertEquals(homePage.getDispenseNowButtonColor(),"rgb(220, 53, 69)");
    }

    @Test
    public void DispenseLinkText(){
        HomePage homePage =  new HomePage(driver);
        Assert.assertEquals(homePage.getDispenseLinkText(),"Dispense Now");
    }

    @Test
    public void DispenseRedirectTextTest(){
        HomePage homePage =  new HomePage(driver);
        homePage.clickDispenseNowButton();
        Assert.assertEquals(homePage.getCashDispensed(),"Cash dispensed");
    }
}
