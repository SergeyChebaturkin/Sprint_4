package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPageScooter {

    private final WebDriver driver;
    private final OrderNotFoundErrorPageScooter orderNotFoundErrorPageScooter;


    //Логотип "Самокат"
    private final By scooterLogo = By
            .xpath(".//img[@alt='Scooter']");

    //Логотип "Яндекс"

    private final By yandexLogo = By
            .xpath(".//img[@alt='Yandex']");

    //Кнопка "Заказать"
    private final By orderButton = By
            .xpath(".//button[@class='Button_Button__ra12g']");

    //Кнопка проверки статуса заказа
    private final By checkOrderButton = By
            .xpath(".//button[@class='Header_Link__1TAG7']");

    //Поле ввода номера заказа
    private final By orderInputField = By
            .xpath(".//input[contains(@class, 'Header_Input__xIoUq')]");

    //Кнопка "Go!" (найти заказ)
    private final By goButton = By
            .xpath(".//button[text()='Go!']");

    public HeaderPageScooter(WebDriver driver) {
        this.driver = driver;
        orderNotFoundErrorPageScooter = new OrderNotFoundErrorPageScooter(driver);
    }

    public By getOrderButton() {
        return orderButton;
    }

    public HeaderPageScooter clickScooterLogo() {
        driver.findElement(scooterLogo).click();
        return this;
    }

    public HeaderPageScooter clickYandexLogo() {
        driver.findElement(yandexLogo).click();
        return this;
    }

    public HeaderPageScooter clickCheckOrder() {
        driver.findElement(checkOrderButton).click();
        return this;
    }

    public HeaderPageScooter inputOrder(String orderName) {
        driver.findElement(orderInputField).sendKeys(orderName);
        return this;
    }

    public HeaderPageScooter clickGo() {
        driver.findElement(goButton).click();
        return this;
    }

    public OrderNotFoundErrorPageScooter notFoundError() {
        return orderNotFoundErrorPageScooter;
    }

}
