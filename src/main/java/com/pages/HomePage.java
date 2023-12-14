package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	//selectors-locators
	private By sectorsPanel = By.cssSelector(".items-start p");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public ArrayList<String> getSectorsList() {

		List<WebElement> sectorsList = driver.findElements(sectorsPanel);
		ArrayList<String> sectorsText = new ArrayList<>();

		for (WebElement e : sectorsList) {
			String sectorText = e.getText();
			sectorsText.add(sectorText);
		}

		return sectorsText;
	}

	public int getSectorsListCount() {
		return driver.findElements(sectorsPanel).size();
	}
}
