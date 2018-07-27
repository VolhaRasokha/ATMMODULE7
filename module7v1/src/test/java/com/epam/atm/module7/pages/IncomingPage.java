package com.epam.atm.module7.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IncomingPage extends BasePage {
	private By SEARCH_INCOMING_MAIL_LOCATOR = By
			.xpath("//*[contains(@href,'https://e.mail.ru/thread/')]");
	private By SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR = By
			.xpath("//div[@class='b-datalist__item__body']//*[@class='b-checkbox__box']");
	private By SEARCH_DELETE_BTN_LOCATOR = By
			.xpath("//*[@id='b-toolbar__right']/div[2]//div[@data-name='remove']");
// Please remove unused imports, remove static final from locators and make their names lower case. 
// Please also think about another locator for SEARCH_DELETE_BTN_LOCATOR, using [2] make a locator week.

	public String getIncomingMailSubject(int index) {
		waitForElementVisible(SEARCH_INCOMING_MAIL_LOCATOR);
		List<WebElement> incomingMails = driver
				.findElements(SEARCH_INCOMING_MAIL_LOCATOR);
		return incomingMails.get(index).getAttribute("data-subject");
	}

	public IncomingPage deleteIncomingMail(int index) {
		waitForElementVisible(SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR);
		List<WebElement> incomingMailsCheckBoxes = driver
				.findElements(SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR);
		WebElement firstIncomingMailCheckBox = incomingMailsCheckBoxes
				.get(index);
		firstIncomingMailCheckBox.click();
		driver.findElement(SEARCH_DELETE_BTN_LOCATOR).click();
		return new IncomingPage();
	}
	
	//Delete mail via context menu and Javascript Executor
	public IncomingPage deleteMailsByActionsJS(){
// 		Please make this method with a parameter of email index. Now the method is not flexible and can deleted only the first email in the list
		List<WebElement> incomingMails = driver.findElements(SEARCH_INCOMING_MAIL_LOCATOR);
		WebElement mail_0 = incomingMails.get(0);
		WebElement mail_1 = incomingMails.get(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow'", mail_0);
		 new Actions(driver).contextClick(mail_0).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'yellow'", mail_1);
		
		 new Actions(driver).contextClick(mail_1).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(SEARCH_DELETE_BTN_LOCATOR));

		return new IncomingPage();
	}

}
