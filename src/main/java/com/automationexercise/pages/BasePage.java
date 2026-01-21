package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

    public WebElement waitUntilVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

    public WebElement find (By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        WebElement webElement = waitUntilElementClickable(locator);
        removeAds();
        try {
            webElement.click();
        } catch (Exception e) {
            // Якщо звичайний клік не пройшов - JS клік "проб'є" оверлей
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        }
    }

    protected void type(By locator, String text) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator);
        removeAds();
        element.clear();
        element.sendKeys(text);
    }

    protected void selectByVisibleText(By locator, String text) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void removeAds() {
        try {
            String script =
                    // 1. Видаляємо нижній банер (твій попередній випадок)
                    "var ads = document.querySelectorAll('ins.adsbygoogle, #aswift_0_host, #aswift_1_host, .adsbygoogle');" +
                            "ads.forEach(function(ad) { ad.remove(); });" +

                            // 2. Видаляємо повноекранний оверлей
                            "var vignette = document.querySelector('#google_vignette');" +
                            "if (vignette) { vignette.remove(); }" +

                            // 3. ПРИМУСОВО повертаємо скрол (реклама його часто вимикає для всієї сторінки)
                            "document.body.style.overflow = 'auto';" +
                            "document.documentElement.style.overflow = 'auto';";

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) {
            // ігноруємо, якщо реклами немає
        }
    }
}