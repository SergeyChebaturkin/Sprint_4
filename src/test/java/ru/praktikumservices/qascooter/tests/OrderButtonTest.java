package ru.praktikumservices.qascooter.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;

public class OrderButtonTest {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkMiddleOrderButtonOpeningFormOnClick() {
        WebDriver driver = browserRule.getWebDriver();
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter
                .open()
                .clickOnMiddleOrderButton();
        assertEquals("https://qa-scooter.praktikum-services.ru/order", driver.getCurrentUrl());
    }
}
