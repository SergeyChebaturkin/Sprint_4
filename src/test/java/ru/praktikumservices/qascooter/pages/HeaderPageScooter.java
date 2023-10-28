package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPageScooter {

    private final WebDriver driver;

    //Кнопка "Заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    public HeaderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderButton() {
        return orderButton;
    }
}
