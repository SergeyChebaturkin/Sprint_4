package ru.praktikumservices.qascooter.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserRule extends ExternalResource {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Override
    protected void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        //webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Override
    protected void after() {
        webDriver.quit();
    }
}