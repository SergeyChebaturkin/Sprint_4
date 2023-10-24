package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePageScooter {
    private final WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Заказать" в хедере
    private final By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");

    //Поле ввода имени на форме заказа
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");

    //
    private final By cookieButton = By.id("rcc-confirm-button");

    //Заголовки выпадающих списков в "Вопросы о важном"
    private final By accordionHeading = By.xpath(".//div[starts-with(@id, 'accordion__heading')]");

    //Тексты выпадающих списков в "Вопросы о важном"
    private final By accordionText = By.xpath(".//div[starts-with(@id, 'accordion__panel')]/p");



    public WebElement getAccordionHeading() {
        return driver.findElement(accordionHeading);
    }

    public WebElement getAccordionText() {
        return driver.findElement(accordionText);
    }

    public void clickOnCookieButton() {
        driver.findElement(cookieButton).click();
    }
}
