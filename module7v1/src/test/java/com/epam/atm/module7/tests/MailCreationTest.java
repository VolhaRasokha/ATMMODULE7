package com.epam.atm.module7.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenShooter;

import com.epam.atm.module7.pages.AccountPage;
import com.epam.atm.module7.pages.BasketPage;
import com.epam.atm.module7.pages.CreateEmailPage;
import com.epam.atm.module7.pages.DraftPage;
import com.epam.atm.module7.pages.HomePage;

public class MailCreationTest extends TestBase {
	private static final String EXPECTED_ACCOUNT_ICON = "vra_atmmodule5@mail.ru"; 
	public static final String MAIL_TO_ADDRESS = "vra_atmmodule6@mail.ru";
	private static long currentKey = System.currentTimeMillis();
	public static final String SUBJECT = "TestSubject" + currentKey;
	private static final String TEXT_BODY = "TestTextBody" + currentKey;

	
	@Test(description = "Login to mail.ru", groups={"test_1"})
	public void mailRuLoginTest() {
		HomePage homePage = new HomePage();
		homePage.startBrowser();
		homePage.login(MAILRU_LOGIN_FIRST_ACCOUNT, MAILRU_PASSWORD_FIRST_ACCOUNT);
		AccountPage accountPage = new AccountPage();
		ScreenShooter.takeScreenshot();
		Assert.assertTrue(accountPage.isEmailPresentOnPage(EXPECTED_ACCOUNT_ICON), "User is not login!");
	}
	
	@Test(description = "Mail creation", dependsOnMethods = { "mailRuLoginTest" }, groups={"test_1"})
	public void mailRuMailCreationTest(){
		AccountPage accountPage = new AccountPage();
		CreateEmailPage mailCreationPage = accountPage.clickMailCreationBtn();
		mailCreationPage.fillMailAddress(MAIL_TO_ADDRESS);
		mailCreationPage.fillMailSubject(SUBJECT);
		mailCreationPage.fillMailBody(TEXT_BODY);
		mailCreationPage.clickSaveDraftBtn();
		accountPage.clickMailDraftMenuLink();
		DraftPage draftPage = new DraftPage();
		String actualSubject = draftPage.getDraftMailSubject(0);
		Assert.assertEquals(actualSubject,SUBJECT);
		
		draftPage.openDraftMail(0);
		String actualMailToAddress =  mailCreationPage.getMailToAddress();
		ScreenShooter.takeScreenshot();
		Assert.assertEquals(actualMailToAddress,MAIL_TO_ADDRESS + ",");	
		Assert.assertTrue(mailCreationPage.isMailBodyEnable(TEXT_BODY),"Required text body has not been found");
	}

}
