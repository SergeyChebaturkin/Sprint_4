package ru.praktikumservices.qascooter.tests;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.pages.OrderPageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;
import static ru.praktikumservices.qascooter.utils.FakeUserData.*;

@RunWith(Parameterized.class)
public class OrderScooterTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private final String name;
    private final String surname;
    private final String address;
    private final int metroIndex;
    private final String phone;
    private final String comment;

    public OrderScooterTest(String name, String surname, String address, int metroIndex, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.metroIndex = metroIndex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {randomFirstName().toLowerCase(), randomSurname().toLowerCase(), randomAddress(), randomMetroIndex(), randomPhone(), ""},
                {randomFirstName().substring(0,2), randomSurname().toUpperCase(), randomAddress(), randomMetroIndex(), randomPhone(), "Дайте самокат для тестировщика"}
        };
    }

    @Test
    public void orderScooterWithHeaderButtonOrderConfirmed() {
        HomePageScooter homePageScooter = new HomePageScooter(browserRule.getWebDriver());
        homePageScooter
                .open()
                .clickOnCookieButton()
                .clickOnOrderButtonInHeader();
        OrderPageScooter orderPageScooter = new OrderPageScooter(browserRule.getWebDriver());
        orderPageScooter
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .chooseMetro(metroIndex)
                .inputTelephone(phone)
                .clickButtonNext()
                .chooseTodayDate()
                .chooseRentPeriodOneDay()
                .activateCheckBoxScooterBlack()
                .inputComment(comment)
                .clickOrderButton()
                .clickConfirmOrderButton();

        Assert.assertTrue("Не показан текст об оформлении заказа", orderPageScooter.checkOrderWasConfirmed());
    }
}
