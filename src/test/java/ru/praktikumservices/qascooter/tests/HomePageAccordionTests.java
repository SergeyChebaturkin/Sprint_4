package ru.praktikumservices.qascooter.tests;

import static org.hamcrest.CoreMatchers.is;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumservices.qascooter.pages.HomePageScooter;

import java.util.List;

@RunWith(Parameterized.class)
public class HomePageAccordionTests {
    private WebDriver driver;
    private final String expectedAccordionText;
    private final boolean result;
    public HomePageAccordionTests(String expectedAccordionText, boolean result) {
        this.expectedAccordionText = expectedAccordionText;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
       return new Object[][] {
               {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
               {"", false}

       };
    }

    @Test
    public void openAndCheckAccordionText() {
            driver = new ChromeDriver();
            HomePageScooter homePageScooter = new HomePageScooter(driver);
            driver.get("https://qa-scooter.praktikum-services.ru/");
            homePageScooter.clickOnCookieButton();
            homePageScooter.getAccordionHeading().click();
            WebElement accordionTextElement = homePageScooter.getAccordionText();
            Assert.assertTrue(accordionTextElement.isDisplayed());
            Assert.assertEquals(accordionTextElement.getText().equals(expectedAccordionText), result);
        }

    @After
    public void tearDown() {
        driver.quit();
    }
    }
