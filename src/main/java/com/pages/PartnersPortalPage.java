package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartnersPortalPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	//selectors-locators
	private By emailID = By.cssSelector("input[name='email']");
	private By loginInButton = By.cssSelector(".button-purple");
	private By errorMessage = By.cssSelector(".error-message-public");
	
	public PartnersPortalPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterUsername(String username) {
		
		eleToBeVisibleWait(emailID).sendKeys(username);
	}
	
	public void clickOnLogin() {
		
		eleToBeClickableWait(loginInButton).click();
	}

	public String portalLoginErrorMessage() {
		//wait for the login error to show
		eleToBeClickableWait(loginInButton);
		return eleToBeVisibleWait(errorMessage).getText();
		
	}
	
	private WebElement eleToBeVisibleWait(By locator) {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	
	private WebElement eleToBeClickableWait(By locator) {
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
}
