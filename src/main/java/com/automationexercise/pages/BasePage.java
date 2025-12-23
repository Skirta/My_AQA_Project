package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Duration defaultTimeout = Duration.ofSeconds(10); // 10с надійніше для UI

    //Конструктор для ініціалізації
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, defaultTimeout);
    }

    // Використовуємо вже створений об'єкт 'wait'
    public WebElement waitUntilVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public WebElement waitUntilVisibilityOfElementLocated(By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Скорочені методи для зручності (click та type)
    protected void click(By locator) {
        waitUntilElementClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUntilVisibilityOfElementLocated(locator);
        element.clear();
        element.sendKeys(text);
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