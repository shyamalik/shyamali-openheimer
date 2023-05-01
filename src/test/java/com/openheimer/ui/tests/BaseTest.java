package com.openheimer.ui.tests;

import com.maxsoft.testngtestresultsanalyzer.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.setDriver;
import com.openheimer.ui.common.DriverManager;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    @BeforeMethod

    public void setUp(){
            driver = new DriverManager().getDriver(Browser.FIREFOX.browserName());
            setDriver(driver);
            getDriver().manage().window().maximize();
            getDriver().get("http://localhost:8080");
        }
    @AfterMethod
    public void teardown() {getDriver().quit();}

}
