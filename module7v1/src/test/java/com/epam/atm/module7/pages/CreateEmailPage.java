package com.epam.atm.module7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateEmailPage extends BasePage{
	
	private By SEARCH_MAIL_TO_ADDRESS_LOCATOR = By.cssSelector("textarea[data-original-name = 'To']");
	private By SEARCH_MAIL_SUBJECT_LOCATOR = By.name("Subject");
	private By SEARCH_MAIL_BODY_LOCATOR = By.xpath("//iframe[starts-with(@id,'toolkit')]");
	private By SEARCH_TEXT_BODY_LOCATOR = By.id("tinymce");
	private By SEARCH_SAVE_DRAFT_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-name='saveDraft']");
	private By SEARCH_MAIL_SEND_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-name='send']");
	private By SEARCH_MAIL_SAVE_STATUS_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-mnemo='saveStatus']");
	private By SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR = By.xpath("//*[@id='compose_to']");

	public CreateEmailPage fillMailAddress(String mailAddress){
		waitForElementVisible(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		highlightElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		driver.findElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR).clear();
		driver.findElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR).sendKeys(mailAddress);
		unHighlightElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		return new CreateEmailPage();
	}
	
	public CreateEmailPage fillMailSubject(String subject){	
		waitForElementVisible(SEARCH_MAIL_SUBJECT_LOCATOR);
		highlightElement(SEARCH_MAIL_SUBJECT_LOCATOR);
		driver.findElement(SEARCH_MAIL_SUBJECT_LOCATOR).clear();
		driver.findElement(SEARCH_MAIL_SUBJECT_LOCATOR).sendKeys(subject);
		unHighlightElement(SEARCH_MAIL_SUBJECT_LOCATOR);
		return new CreateEmailPage();
	}
	
	public CreateEmailPage fillMailBody(String body){
		waitForElementVisible(SEARCH_MAIL_BODY_LOCATOR);
		WebElement mailBody = driver.findElement(SEARCH_MAIL_BODY_LOCATOR);
		driver.switchTo().frame(mailBody);
		highlightElement(SEARCH_TEXT_BODY_LOCATOR);
		driver.findElement(SEARCH_TEXT_BODY_LOCATOR).clear();
		driver.findElement(SEARCH_TEXT_BODY_LOCATOR).sendKeys(body);
		unHighlightElement(SEARCH_TEXT_BODY_LOCATOR);
		driver.switchTo().defaultContent();	
		return new CreateEmailPage();
	}
	
	public CreateEmailPage clickSaveDraftBtn(){
		highlightElement(SEARCH_SAVE_DRAFT_BTN_LOCATOR);
		driver.findElement(SEARCH_SAVE_DRAFT_BTN_LOCATOR).click();
		unHighlightElement(SEARCH_SAVE_DRAFT_BTN_LOCATOR);
		waitForElementVisible(SEARCH_MAIL_SAVE_STATUS_LOCATOR);
		highlightElement(SEARCH_MAIL_SAVE_STATUS_LOCATOR);
		unHighlightElement(SEARCH_MAIL_SAVE_STATUS_LOCATOR);
		return new CreateEmailPage(); 
	}

	
	public SentInfoPage clickMailSendBtn(){
		waitForElementVisible(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		waitForElementVisible(SEARCH_MAIL_SEND_BTN_LOCATOR);
		highlightElement(SEARCH_MAIL_SEND_BTN_LOCATOR);
		unHighlightElement(SEARCH_MAIL_SEND_BTN_LOCATOR);
		driver.findElement(SEARCH_MAIL_SEND_BTN_LOCATOR).click();
		return new SentInfoPage();
	}
	
	public String getMailToAddress(){
		waitForElementPresent(SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR);
		return driver.findElement(SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR).getAttribute("value");
	}
	
	public boolean isMailBodyEnable(String text_body){
		By SEARCH_ACTUAL_MAIL_BODY_LOCATOR = By.xpath("//*[text()= '" + text_body + "']");
		return driver.findElement(SEARCH_ACTUAL_MAIL_BODY_LOCATOR).isEnabled();
	}
	
	public CreateEmailPage fillMailByJS(){
		new Actions(driver).sendKeys(driver.findElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR), "vra_atmmodule6@mail.ru").build().perform();
		new Actions(driver).sendKeys(driver.findElement(SEARCH_MAIL_SUBJECT_LOCATOR), "test"+ System.nanoTime()).build().perform();
		
		WebElement mailBody = driver.findElement(SEARCH_MAIL_BODY_LOCATOR);
		driver.switchTo().frame(mailBody);
		new Actions(driver).sendKeys(driver.findElement(SEARCH_TEXT_BODY_LOCATOR), "to test actions").build().perform();
		driver.switchTo().defaultContent();		
		return new CreateEmailPage();
	}
	
}
