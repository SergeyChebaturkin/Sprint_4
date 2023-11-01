package ru.praktikumservices.qascooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {

    private final WebDriver driver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/order";

    //Поле ввода имени
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");

    //Поле ввода фамилии
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле ввода адреса
    private final By inputAddress = By
            .xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Селект выбора станции метро
    private final By selectOfMetroStations = By.className("select-search__input");

    //Поле ввода телефона
    private final By inputTelephone = By
            .xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    private final By buttonNext = By.xpath(".//button[text()='Далее']");

    //Кнопка отображения календаря
    private final By inputShowDatePicker = By
            .xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Кнопка выбора даты "сегодня"
    private final By buttonChooseTodayDay = By
            .cssSelector(".react-datepicker__day--today");

    //Кнопка выпадающего списка "Срок аренды"
    private final By dropdownRentPeriod = By
            .cssSelector(".Dropdown-control");

    //Элемент выпадающего списка "Сутки"
    private final By dropdownOptionDay = By
            .xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    //Чек-бокс цвета самоката - черный
    private final By checkBoxScooterColorBlack = By
            .xpath(".//input[@class='Checkbox_Input__14A2w' and @id='black']");

    //Чек-бокс цвета самоката - серый
    private final By checkBoxScooterColorGrey = By.
            xpath(".//input[@class='Checkbox_Input__14A2w' and @id='grey']");

    //Поле ввода комментария
    private final By inputComment = By.
            xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать" на форме заказа
    private final By orderButton = By
            .xpath(".//button[contains(@class,'Button_Middle__1CSJM') and text()='Заказать']");

    //Кнопка подтверждения заказа
    private final By confirmOrderButtonModal = By
            .xpath(".//button[contains(@class,'Button_Middle__1CSJM') and text()='Да']");

    //Заголовок модального окна для проверки успешности заказа (проверяем текст = "Заказ оформлен")
    private final By modalWindowHeaderWithConfirmedOrder = By
            .xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public static String getUrl() {
        return URL;
    }

    public OrderPageScooter inputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    public OrderPageScooter inputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }

    public OrderPageScooter inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    public OrderPageScooter chooseMetro(int numberOfListElement) {
        driver.findElement(selectOfMetroStations).click();
        driver.findElement(By.xpath(String
                                .format(".//ul[@class='select-search__options']/li[%d]/button", numberOfListElement)))
                                .click();
        return this;
    }

    public OrderPageScooter inputTelephone(String telephone) {
        driver.findElement(inputTelephone).sendKeys(telephone);
        return this;
    }

    public OrderPageScooter clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }

    public OrderPageScooter chooseTodayDate() {
        driver.findElement(inputShowDatePicker).click();
        driver.findElement(buttonChooseTodayDay).click();
        return this;
    }

    public OrderPageScooter chooseRentPeriodOneDay() {
        driver.findElement(dropdownRentPeriod).click();
        driver.findElement(dropdownOptionDay).click();
        return this;
    }

    public OrderPageScooter activateCheckBoxScooterBlack() {
        driver.findElement(checkBoxScooterColorBlack).click();
        return this;
    }

    public OrderPageScooter inputComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
        return this;
    }

    public OrderPageScooter clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPageScooter clickConfirmOrderButton() {
        driver.findElement(confirmOrderButtonModal).click();
        return this;
    }

    public boolean checkOrderWasConfirmed() {
        return driver.findElements(modalWindowHeaderWithConfirmedOrder).size() > 0;
    }
}