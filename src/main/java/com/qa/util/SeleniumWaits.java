package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

    // Wait for an element with the specified condition
    public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds, WaitCondition condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        switch (condition) {
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            default:
                throw new IllegalArgumentException("Unsupported wait condition: " + condition);
        }
    }

    // Enum for different wait conditions
    public enum WaitCondition {
        VISIBLE,
        CLICKABLE,
        PRESENCE
    }
}