package ru.praktikumservices.qascooter.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikumservices.qascooter.pages.HeaderPageScooter;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class HeaderLogoTests {

    @Rule
    public BrowserRule browserRule = new BrowserRule();


    @Test
    public void goToMainPageWhenScooterLogoClicked() {
        HomePageScooter homePageScooter = new HomePageScooter(browserRule.getWebDriver());
        HeaderPageScooter headerPageScooter = new HeaderPageScooter(browserRule.getWebDriver());

        homePageScooter.open().clickOnOrderButtonInHeader();
        headerPageScooter.clickScooterLogo();
        assertEquals(browserRule.getWebDriver().getCurrentUrl(), homePageScooter.getUrl());
    }

    @Test
    public void goToTheNewTabWithYandexHomepageWhenYandexLogoClicked() {
        WebDriver driver = browserRule.getWebDriver();
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        HeaderPageScooter headerPageScooter = new HeaderPageScooter(driver);
        homePageScooter.open();
        headerPageScooter.clickYandexLogo();
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                assertEquals("Дзен", driver.getTitle());
                driver.close();
                driver.switchTo().window(parentWindow);
            }
        }
    }
}
