package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public WebElement waitUntilElementClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
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
                    // 1. Видаляємо всі елементи, що містять атрибути віньєтки або interstitial
                    "var googleVignettes = document.querySelectorAll('[data-google-vignette], [data-google-interstitial], .google-ads-interstitial, #google_vignette');" +
                            "googleVignettes.forEach(function(el) { el.remove(); });" +

                            // 2. Видаляємо стандартні хости реклами (як у тебе було, але розширено)
                            "var ads = document.querySelectorAll('ins.adsbygoogle, [id^=\"aswift_\"], .adsbygoogle');" +
                            "ads.forEach(function(ad) { ad.remove(); });" +

                            // 3. ПРИМУСОВО розблоковуємо скрол та взаємодію з body
                            // Google Ads часто вішає 'overflow: hidden' на <html> або <body>, щоб юзер не міг скролити повз рекламу
                            "var styleFix = 'overflow: auto !important; position: static !important; user-select: auto !important; pointer-events: auto !important;';" +
                            "document.body.setAttribute('style', styleFix);" +
                            "document.documentElement.setAttribute('style', styleFix);";

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) {
            // Логування помилки, якщо потрібно
        }
    }

    public void clickAcceptButtonInAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
