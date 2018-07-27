package com.epam.atm.module7.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

	private static final String MAILRU_URL = "https://mail.ru/";
	
	private static final By SEARCH_LOGIN_LOCATOR = By.id("mailbox:login");
	private static final By SEARCH_PASSWORD_LOCATOR = By.id("mailbox:password");
	private static final By SEARCH_SUBMIT_LOCATOR = By.id("mailbox:submit");
	
	public HomePage startBrowser(){
		driver.get(MAILRU_URL);
		return new HomePage();
	}
	
	public AccountPage login(String login, String password ){
		highlightElement(SEARCH_LOGIN_LOCATOR);
		driver.findElement(SEARCH_LOGIN_LOCATOR).clear();
		driver.findElement(SEARCH_LOGIN_LOCATOR).sendKeys(login);
		unHighlightElement(SEARCH_LOGIN_LOCATOR);
		
		highlightElement(SEARCH_PASSWORD_LOCATOR);
		driver.findElement(SEARCH_PASSWORD_LOCATOR).clear();
		driver.findElement(SEARCH_PASSWORD_LOCATOR).sendKeys(password);
		unHighlightElement(SEARCH_PASSWORD_LOCATOR);
		
		highlightElement(SEARCH_SUBMIT_LOCATOR);
		unHighlightElement(SEARCH_SUBMIT_LOCATOR);
		//driver.findElement(SEARCH_SUBMIT_LOCATOR).click();
		
		new Actions(driver).click(driver.findElement(SEARCH_SUBMIT_LOCATOR)).build().perform();
		return new AccountPage();
	}
	
}
