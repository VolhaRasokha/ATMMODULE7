package com.epam.atm.module7.tests;

import org.testng.annotations.Test;

import com.epam.atm.module7.pages.AccountPage;
import com.epam.atm.module7.pages.CreateEmailPage;
import com.epam.atm.module7.pages.HomePage;
import com.epam.atm.module7.pages.IncomingPage;

public class MailDeleteViaActionJS extends TestBase{
	
	@Test(description = "To test actions")
	public void actionsTest(){
		
		HomePage homePage = new HomePage();
		homePage.startBrowser();
		homePage.login(MAILRU_LOGIN_FIRST_ACCOUNT, MAILRU_PASSWORD_FIRST_ACCOUNT);
		
		AccountPage accountPage = new AccountPage();
		CreateEmailPage mailCreationPage = accountPage.clickMailCreationBtn();
		mailCreationPage.fillMailByJS();
		mailCreationPage.clickMailSendBtn();
		
	    accountPage.clickMailCreationBtn();
		mailCreationPage.fillMailByJS();
		mailCreationPage.clickMailSendBtn();
		
		
		accountPage.clickLogOut();
		
		homePage.login(MAILRU_LOGIN_SECOND_ACCOUNT, MAILRU_PASSWORD_SECOND_ACCOUNT);
		
		IncomingPage incomingPage = new IncomingPage();
		incomingPage.deleteMailsByActionsJS();
		

		
	}
	

}
