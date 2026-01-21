package com.automationexercise.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    // ThreadLocal дозволяє безпечно запускати тести паралельно
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        // Приватний конструктор, щоб ніхто не міг створити об'єкт класу через new
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) { // перевірка на те чи є вже створений драйвер для цього тесту\потоку
            driverThreadLocal.set(createDriver()); // якщо нема драйверу - то створюємо новий
        }
        return driverThreadLocal.get(); // віддаємо драйвер до тесту
    }

    private static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");

        // Твої налаштування prefs залишаємо тут
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove(); // Обов'язково чистимо потік!
        }
    }
}