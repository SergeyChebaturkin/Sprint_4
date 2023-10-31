package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderNotFoundErrorPageScooter {

    private final WebDriver driver;
    private final By notFound = By.xpath(".//img[@alt='Not found']");

    public OrderNotFoundErrorPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkShown() {
        return driver.findElements(notFound).size() > 0;
    }
}