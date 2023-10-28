package ru.praktikumservices.qascooter.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import ru.praktikumservices.qascooter.constants.Constants;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.pages.OrderPageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;
import ru.praktikumservices.qascooter.utils.Utils;

import java.util.Locale;

public class OrderScooter {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void orderScooterWithOptionalFieldsOrderConfirmed() {
        HomePageScooter homePageScooter = new HomePageScooter(browserRule.getWebDriver());
        homePageScooter
                .open()
                .clickOnCookieButton()
                .clickOnOrderButtonInHeader();
        OrderPageScooter orderPageScooter = new OrderPageScooter(browserRule.getWebDriver());
        orderPageScooter
                .inputName(Utils.getRandomWord(6, Constants.russianAlphabet))
                .inputSurname(Utils.getRandomWord(10, Constants.russianAlphabet))
                .inputAddress(Utils.getRandomWord(16, Constants.russianAlphabet))
                .chooseMetro(2)
                .inputTelephone(Utils.getRandomPhone())
                .clickButtonNext()
                .chooseTodayDate()
                .chooseRentPeriodOneDay()
                .activateCheckBoxScooterBlack()
                .inputComment(Utils.getRandomWord(6, Constants.russianAlphabet))
                .clickOrderButton()
                .clickConfirmOrderButton();

        Assert.assertTrue("Не показан текст об оформлении заказа", orderPageScooter.checkOrderWasConfirmed());

    }
}
