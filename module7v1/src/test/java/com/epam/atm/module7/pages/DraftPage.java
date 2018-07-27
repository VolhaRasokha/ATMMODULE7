package com.epam.atm.module7.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraftPage extends AccountPage {
	private By SEARCH_DRAFT_MAIL_LOCATOR = By
			.xpath("//*[contains(@href,'https://e.mail.ru/compose/')]");
// Please remove unused imports and make locator name lower case
	public WebElement getDraftMail(int index) {
		waitForElementVisible(SEARCH_DRAFT_MAIL_LOCATOR);
		List<WebElement> draftMails = driver
				.findElements(SEARCH_DRAFT_MAIL_LOCATOR);
		WebElement draftMail = draftMails.get(index);
		return draftMail;
// 		This method is used from the page only. So it's a good idea to make it private. Private methods are usually put after all the public methods.
	}

	public CreateEmailPage getDraftMailBySubject(String by_subject) {
// 		It's better to use one approach for variable names. So bySubject will be better. Since it's a string, just subject is enough
		By SearchDraftMailBySubjectLicator = By.partialLinkText(by_subject);
// 		SearchDraftMailBySubjectLicator variable should start from lower case character
		waitForElementVisible(SearchDraftMailBySubjectLicator);
		highlightElement(SearchDraftMailBySubjectLicator);
		unHighlightElement(SearchDraftMailBySubjectLicator);
		driver.findElement(SearchDraftMailBySubjectLicator).click();
		return new CreateEmailPage();
	}

	public String getDraftMailSubject(int index) {
		WebElement draftMail = getDraftMail(index);
		return draftMail.getAttribute("data-subject");
// 		Not a mistake, but a good practice to reduce code lines by return getDraftMail(index).getAttribute("data-subject");
	}

	public CreateEmailPage openDraftMail(int index) {
		WebElement draftMail = getDraftMail(index);
		draftMail.click();
		return new CreateEmailPage();
	}
}
