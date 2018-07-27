package com.epam.atm.module7.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
// Please remove unused imports
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasketPage extends AccountPage {
	private By SEARCH_MAILS_IN_TRASH_LOCATOR = By
			.xpath("//a[contains(@href,'https://e.mail.ru/thread/')]");
// 	Please make a locator name lower case
	
	public BasketPage dragNDropMailFromDraftToBasket(int index){
		waitForElementVisible(SEARCH_MAILS_IN_TRASH_LOCATOR);
		highlightElement(SEARCH_MAILS_IN_TRASH_LOCATOR);
		WebElement element = driver.findElements(SEARCH_MAILS_IN_TRASH_LOCATOR).get(index);
		WebElement target = driver.findElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		highlightElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		unHighlightElement(SEARCH_MAILS_IN_TRASH_LOCATOR);
		new Actions(driver).dragAndDrop(element,target).build().perform();
		System.out.println("DragAndDrop was successeful!");
		return this;
	}
	
	public String getDeleteMailSubject(int index) {
		waitForElementPresent(SEARCH_MAILS_IN_TRASH_LOCATOR);
		List<WebElement> deleteMails = driver
				.findElements(SEARCH_MAILS_IN_TRASH_LOCATOR);
		WebElement deleteMail = deleteMails.get(index);
		return deleteMail.getAttribute("data-subject");
	}
	
    public BasketPage refresh(){
    	driver.navigate().refresh();
    	return new BasketPage();
// This method is applicable to any page. Please move it into base page.
    }
	
}
