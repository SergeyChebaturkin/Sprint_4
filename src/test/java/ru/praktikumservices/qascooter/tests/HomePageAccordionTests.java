package ru.praktikumservices.qascooter.tests;

import static org.hamcrest.CoreMatchers.is;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import ru.praktikumservices.qascooter.pages.HomePageScooter;
import ru.praktikumservices.qascooter.rules.BrowserRule;

@RunWith(Parameterized.class)
public class HomePageAccordionTests {

    @Rule
    public BrowserRule browserRule = new BrowserRule();
    private final int id;
    private final String expectedAccordionHeading;
    private final String expectedAccordionText;
    public HomePageAccordionTests(int id, String expectedAccordionHeading, String expectedAccordionText) {
        this.id = id;
        this.expectedAccordionHeading = expectedAccordionHeading;
        this.expectedAccordionText = expectedAccordionText;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
       return new Object[][] {
               {0, "Сколько это стоит? И как оплатить?" , "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
               {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
               {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
               {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
               {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
               {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
               {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
               {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
       };
    }

    @Test
    public void openAndCheckAccordionText() {
        HomePageScooter homePageScooter = new HomePageScooter(browserRule.getWebDriver());
        homePageScooter.open().clickOnCookieButton();
        WebElement accordionHeading = homePageScooter.getAccordionHeading(id);
        Assert.assertEquals("Ошибка сравнения заголовков", expectedAccordionHeading, accordionHeading.getText());
        accordionHeading.click();
        WebElement accordionText = homePageScooter.getAccordionText(id);
        Assert.assertEquals("Ошибка сравнения текстов", expectedAccordionText, accordionText.getText());
    }
}
