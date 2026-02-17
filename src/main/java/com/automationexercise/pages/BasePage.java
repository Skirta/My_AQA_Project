package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Duration defaultTimeout = Duration.ofSeconds(5);

    //Конструктор для ініціалізації
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, defaultTimeout);
    }

    public Boolean waitUntilUrlToBe(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    public Boolean waitUntilUrlContains(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }

    public WebElement waitUntilVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waitUntilInvisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
    }

    public Boolean waitUntilTextToBeInElement(By locator, String expectedText) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public WebElement waitUntilVisibilityOfElementLocated(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> waitUntilNumberOfElementsToBeMoreThan(By locator, int value) {
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, value));
    }

    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        WebElement webElement = waitUntilElementClickable(locator);
        click(webElement);
    }

    protected void click(WebElement webElement) {
        removeAds();
        webElement.click();
    }

    protected void type(By locator, String text) {
        WebElement webElement = waitUntilVisibilityOfElementLocated(locator);
        removeAds();
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void selectByVisibleText(By locator, String text) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void removeAds() {
        try {
            String script =
                    "var ads = document.querySelectorAll('ins.adsbygoogle, #aswift_0_host, #aswift_1_host, .adsbygoogle');" +
                            "ads.forEach(function(ad) { ad.remove(); });" +

                            "var vignette = document.querySelector('#google_vignette');" +
                            "if (vignette) { vignette.remove(); }" +

                            "var overlays = document.querySelectorAll('span[style*=\"blue\"], a[href*=\"v-neck\"]');" +
                            "overlays.forEach(function(o) { o.remove(); });" +

                            "document.body.style.overflow = 'auto';" +
                            "document.documentElement.style.overflow = 'auto';";

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) { }
    }

    public void clickAcceptButtonInAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
