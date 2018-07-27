package com.epam.atm.module7.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.WebDriverSingleton;

import com.epam.atm.module7.pages.AccountPage;

public class TestBase {
	protected WebDriver driver;
	protected static final String MAILRU_LOGIN_FIRST_ACCOUNT = "vra_atmmodule5";
	protected static final String MAILRU_PASSWORD_FIRST_ACCOUNT = "123456789_Vra";
	protected static final String MAILRU_LOGIN_SECOND_ACCOUNT = "vra_atmmodule6";
	protected static final String MAILRU_PASSWORD_SECOND_ACCOUNT = "123456789_Vra";
	protected static final String MAILRU_URL = "https://mail.ru/";
	
	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		new AccountPage().clickLogOut();
		WebDriverSingleton.kill();
	}

}
