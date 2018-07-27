package com.epam.atm.module7.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraftPage extends AccountPage {
	private By SEARCH_DRAFT_MAIL_LOCATOR = By
			.xpath("//*[contains(@href,'https://e.mail.ru/compose/')]");

	public WebElement getDraftMail(int index) {
		waitForElementVisible(SEARCH_DRAFT_MAIL_LOCATOR);
		List<WebElement> draftMails = driver
				.findElements(SEARCH_DRAFT_MAIL_LOCATOR);
		WebElement draftMail = draftMails.get(index);
		return draftMail;
	}

	public CreateEmailPage getDraftMailBySubject(String by_subject) {
		By SearchDraftMailBySubjectLicator = By.partialLinkText(by_subject);
		waitForElementVisible(SearchDraftMailBySubjectLicator);
		highlightElement(SearchDraftMailBySubjectLicator);
		unHighlightElement(SearchDraftMailBySubjectLicator);
		driver.findElement(SearchDraftMailBySubjectLicator).click();
		return new CreateEmailPage();
	}

	public String getDraftMailSubject(int index) {
		WebElement draftMail = getDraftMail(index);
		return draftMail.getAttribute("data-subject");
	}

	public CreateEmailPage openDraftMail(int index) {
		WebElement draftMail = getDraftMail(index);
		draftMail.click();
		return new CreateEmailPage();
	}
}
