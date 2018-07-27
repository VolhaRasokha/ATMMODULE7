package com.epam.atm.module7.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenShooter;

import com.epam.atm.module7.pages.AccountPage;
import com.epam.atm.module7.pages.CreateEmailPage;
import com.epam.atm.module7.pages.DraftPage;
import com.epam.atm.module7.pages.HomePage;
import com.epam.atm.module7.pages.IncomingPage;
import com.epam.atm.module7.pages.SentInfoPage;
import com.epam.atm.module7.pages.SentPage;

public class MailSendTest extends TestBase{
	private By SEARCH_MAIL_SENT_TITLE_LOCATOR = By.cssSelector("[class='message-sent__title']");
	
	@Test(description = "Mail sending", dependsOnGroups = {"test_1"}, groups={"test_2"})
	public void mailRuMailSendingTest() {
		HomePage homePage = new HomePage();
		homePage.startBrowser();
		homePage.login(MAILRU_LOGIN_FIRST_ACCOUNT, MAILRU_PASSWORD_FIRST_ACCOUNT);
		
		AccountPage accountPage = new AccountPage();
		accountPage.clickMailDraftMenuLink();
		
		DraftPage draftPage = new DraftPage();
		String actualSubject = draftPage.getDraftMailSubject(0);
		draftPage.getDraftMailBySubject(actualSubject);
		
		CreateEmailPage mailCreationPage = new CreateEmailPage();
		mailCreationPage.clickMailSendBtn();
		
		SentInfoPage mailSentInfoPage = new SentInfoPage();
		mailSentInfoPage.isElementPresent(SEARCH_MAIL_SENT_TITLE_LOCATOR);
		
		accountPage.clickMailDraftMenuLink();
		
		ScreenShooter.takeScreenshot();
		Assert.assertFalse(draftPage.isEmailPresentOnPage(actualSubject), "Email exists in Draft folder");
		
		accountPage.clickMailSentMenuLink();
		SentPage sentPage = new SentPage();
		ScreenShooter.takeScreenshot();
		Assert.assertTrue(sentPage.isEmailPresentOnPage(actualSubject), "Email does not exist in SENT folder");
		
		accountPage.clickLogOut();
		
		homePage.login(MAILRU_LOGIN_SECOND_ACCOUNT, MAILRU_PASSWORD_SECOND_ACCOUNT);

		accountPage.clickMailIncomingMenuLink();
		IncomingPage incomingPage = new IncomingPage();
		ScreenShooter.takeScreenshot();
		Assert.assertTrue(incomingPage.isEmailPresentOnPage(actualSubject));
	}

}
