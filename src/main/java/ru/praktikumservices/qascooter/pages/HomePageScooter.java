package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {
    private final WebDriver driver;
    private final HeaderPageScooter headerPageScooter;
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "Принять cookie"
    private final By cookieButton = By.id("rcc-confirm-button");

    //Нижняя кнопка "Заказать"
    private final By middleOrderButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM')]");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
        headerPageScooter = new HeaderPageScooter(driver);
    }

    public HomePageScooter open() {
        driver.get(URL);
        return this;
    }
    public static String getUrl() {
        return URL;
    }

    public WebElement getAccordionHeading(int id) {
        return driver.findElement(By.id("accordion__heading-" + id));
    }

    public WebElement getAccordionText(int id) {
        return driver.findElement(By
                .xpath(".//div[@id='accordion__panel-" + id + "']/p"));
    }

    public HomePageScooter clickOnCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    public HomePageScooter clickOnOrderButtonInHeader() {
        driver.findElement(headerPageScooter.getOrderButton()).click();
        return this;
    }

    public HomePageScooter clickOnMiddleOrderButton() {
        WebElement element = driver.findElement(middleOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        return this;
    }

}
