package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericToPages {

	private WebDriver driver;
	private WebDriverWait wait;

	//selectors-locators
	private By cookieBoxButton = By.id("ccc-notify-accept");
	private By cookieBox = By.id("ccc-notify");

	public GenericToPages(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void cookieAcceptBox() {

		WebElement cookieBoxEle = eleToBeVisibleWait(cookieBox);
		WebElement cookieBoxBtnEle = eleToBeClickableWait(cookieBoxButton);

		waitForAnimationToStabilize(cookieBoxEle);
		cookieBoxBtnEle.click();
	}

	private WebElement eleToBeVisibleWait(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private WebElement eleToBeClickableWait(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Function to wait for the cookie slide up animation to finish
	private void waitForAnimationToStabilize(WebElement element) {

		// custom condition to wait for the animation to stabilise
		wait.until(webDriver -> {
			// Get the initial position of the element
			int initialY = element.getLocation().getY();

			// Wait for a short delay
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Get the current position of the element after the delay
			int currentY = element.getLocation().getY();

			// Check if element's position is stable (not changing)
			return initialY == currentY;
		});
	}

}
