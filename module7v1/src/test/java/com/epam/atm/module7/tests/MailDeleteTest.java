package com.epam.atm.module7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenShooter;

import com.epam.atm.module7.pages.AccountPage;
import com.epam.atm.module7.pages.BasketPage;
import com.epam.atm.module7.pages.DraftPage;
import com.epam.atm.module7.pages.HomePage;
import com.epam.atm.module7.pages.IncomingPage;


public class MailDeleteTest extends TestBase {
	@Test (description = "Mail delete", dependsOnGroups = {"test_2"}, groups={"test_3"})
	public void mailRuMailDeleteTest() {
		
		HomePage homePage = new HomePage();
		homePage.startBrowser();
		homePage.login(MAILRU_LOGIN_SECOND_ACCOUNT, MAILRU_PASSWORD_SECOND_ACCOUNT);
// 		login method returns new AccountPage, no need to create one more instance. That is AccountPage accountPage = homePage.login(MAILRU_LOGIN_SECOND_ACCOUNT, MAILRU_PASSWORD_SECOND_ACCOUNT);
// 		Please make such changes to all such cases and in all tests.
		AccountPage accountPage = new AccountPage();
		accountPage.clickMailIncomingMenuLink();
		
		IncomingPage incomingPage = new IncomingPage();		
		String subjectDeleteIncomingMail = incomingPage.getIncomingMailSubject(0);
		incomingPage.deleteIncomingMail(0);	
		ScreenShooter.takeScreenshot();
	    Assert.assertFalse(incomingPage.isEmailPresentOnPage(subjectDeleteIncomingMail));
	    
	    accountPage.clickBasketMenuLink();
	    BasketPage basketPage = new BasketPage();
	    basketPage.refresh();
	    ScreenShooter.takeScreenshot();
	    Assert.assertTrue(basketPage.isEmailPresentOnPage(subjectDeleteIncomingMail));	
	}
	
	@Test(description = "Mail drag and drop from Basket to DRAFT", dependsOnGroups = {"test_2"}, dependsOnMethods = { "mailRuMailDeleteTest" }, groups={"test_3"})

	public void dragNDropMailTest(){
		AccountPage accountPage = new AccountPage();
		accountPage.clickBasketMenuLink();
		BasketPage basketPage = new BasketPage();
		String subject = basketPage.getDeleteMailSubject(0);
		basketPage.refresh();
		basketPage.dragNDropMailFromDraftToBasket(0);		

		basketPage.refresh();		
		accountPage.clickMailDraftMenuLink();
		
		DraftPage draftPage = new DraftPage();
		ScreenShooter.takeScreenshot();
		Assert.assertTrue(draftPage.isEmailPresentOnPage(subject), "Email is not drag and drop to Basket");
	}
	


}
