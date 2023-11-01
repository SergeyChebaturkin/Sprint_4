package ru.praktikumservices.qascooter.tests;

import org.junit.Rule;
import org.junit.Test;
import ru.praktikumservices.qascooter.pages.HeaderPageScooter;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;
import ru.praktikumservices.qascooter.utils.FakeUserData;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest {

    private static final String NOT_EXISTING_ORDER = FakeUserData.randomNumber();

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void notFoundIfOrderNotExists() {
        HeaderPageScooter headerPageScooter = new HeaderPageScooter(browserRule.getWebDriver());
        browserRule.getWebDriver().get(HomePageScooter.getUrl());
        headerPageScooter
                .clickCheckOrder()
                .inputOrder(NOT_EXISTING_ORDER)
                .clickGo();

        assertTrue("Не показано сообщение об отсутствии заказа",
                headerPageScooter.notFoundError().checkShown());
    }
}