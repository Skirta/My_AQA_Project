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
        waitUntilElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator);
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
            // Тут використовуємо швидкий вейтер на 2 секунди
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("adsbygoogle")));
            // Тут буде твій JS код видалення
        } catch (Exception e) {
            // Реклами немає — ігноруємо
        }
    }
}