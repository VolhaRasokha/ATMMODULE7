package com.epam.atm.module7.pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage {

	private By SEARCH_AUT_ICON_LOCATOR = By.xpath("//*[@id='PH_user-email']");
	private By SEARCH_MAIL_CREATION_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__left']//a[(@data-name = 'compose')]");
	protected By SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_drafts')]");
	private By SEARCH_MAIL_SENT_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_send')]");
	private By SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_inbox')]");
	private By SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR = By.xpath("//*[@id='b-nav_folders']//i[contains(@class,'ico_folder_trash')]");
	private By SEARCH_LOGOUT_LOCATOR = By.id("PH_logoutLink");
	
	
	public String getEmailAddressText(){
		waitForElementPresent(SEARCH_AUT_ICON_LOCATOR);
		highlightElement(SEARCH_AUT_ICON_LOCATOR);
		unHighlightElement(SEARCH_AUT_ICON_LOCATOR);
		return driver.findElement(SEARCH_AUT_ICON_LOCATOR).getText();
	}
	
	public CreateEmailPage clickMailCreationBtn(){
		waitForElementVisible(SEARCH_MAIL_CREATION_BTN_LOCATOR);
		highlightElement(SEARCH_MAIL_CREATION_BTN_LOCATOR);
		driver.findElement(SEARCH_MAIL_CREATION_BTN_LOCATOR).click();
		unHighlightElement(SEARCH_MAIL_CREATION_BTN_LOCATOR);
		return new CreateEmailPage();
	}
	
	public DraftPage clickMailDraftMenuLink(){
		waitForElementVisible(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		highlightElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		driver.findElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR).click();
		return new DraftPage();
	}
	
	public SentPage clickMailSentMenuLink(){
		waitForElementVisible(SEARCH_MAIL_SENT_MENU_LINK_LOCATOR);
		highlightElement(SEARCH_MAIL_SENT_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAIL_SENT_MENU_LINK_LOCATOR);
		driver.findElement(SEARCH_MAIL_SENT_MENU_LINK_LOCATOR).click();
		return new SentPage();
	}
	
	public IncomingPage clickMailIncomingMenuLink(){
		waitForElementVisible(SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR);
		highlightElement(SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR);
		driver.findElement(SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR).click();
		return new IncomingPage();
	}
	
	public BasketPage clickBasketMenuLink(){
		waitForElementVisible(SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR);
		highlightElement(SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR);
		driver.findElement(SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR).click();
		return new BasketPage();
	}
	
	public HomePage clickLogOut(){
		waitForElementVisible(SEARCH_LOGOUT_LOCATOR);
		highlightElement(SEARCH_LOGOUT_LOCATOR);
		unHighlightElement(SEARCH_LOGOUT_LOCATOR);
		driver.findElement(SEARCH_LOGOUT_LOCATOR).click();
		return new HomePage();
	}

}
