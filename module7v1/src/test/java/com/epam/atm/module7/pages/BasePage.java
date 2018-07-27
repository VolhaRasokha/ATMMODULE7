package com.epam.atm.module7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
// Please remove unused imports: Actions, Keys
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverSingleton;

public class BasePage {
	protected WebDriver driver;
	private static final int DEFAULT_TIMEOUT = 15;
// 	Constants usually placed on the first place, then go protected, public variables

	public BasePage() {
		this.driver = WebDriverSingleton.getWebDriverInstance();
	}

	protected void waitForElementVisible(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
	
	protected void waitForElementPresent(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
	
	public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

	public boolean isEmailPresentOnPage(String by_subject) {
		return isElementPresent(By.xpath("//*[text()='" + by_subject + "']"));
	}
	
	protected void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
    }

    protected void unHighlightElement(By locator) {
    	WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = ''", element);
    }
    
    private ExpectedCondition<Boolean> isAjaxFinished() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            }
        };
    }

    protected void waitForAjaxProcessed() {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(isAjaxFinished());
    }
// The waitForAjaxProcessed() method is never used
}
