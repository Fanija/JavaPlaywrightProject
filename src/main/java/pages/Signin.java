package pages;

import utils.*;
import pages.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;

public class Signin {
	
	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Register Register;
	
	//private final Page page;

	public Signin(Page page) {
		this.page = page;
		
	}

	public void Login(String email, String password){
		
		EmailSignin().fill("test@testing.com");
		PasswordSignin().fill("Testovski123");
		SigninButton().click();
	}
	

	public Locator EmailSignin() {
        Locator EmailSignin = page.locator("//input[@id=\"field-email\"]");
        return EmailSignin;
	}
	
	public Locator PasswordSignin() {
		Locator PasswordSignin = page.locator("//input[@id=\"field-password\"]");
		return PasswordSignin;
	}
	
	public Locator EmptyPassword() {
		return page.locator("//input[@id=\"field-password\"]");
	}
	
    public Locator SigninButton() {
    	Locator SigninButton = page.locator("//button[@id=\"submit-login\"]");
    	return SigninButton;
    }
    
    public void ForgotYourPassword() {
    	ForgotPassword().click();
		ForgotEmailAddress().click();
		ForgotEmailAddress().fill(common.generateRandomEmail());
		ResetLink().click();
    }
    
	public Locator ForgotPassword() {
		Locator ForgotPassword = page.locator("//div[@class=\"forgot-password\"]/a");
		return ForgotPassword;
	}
	
	public Locator ForgotEmailAddress() {
        Locator ForgotEmailAddress = page.locator("//input[@id=\"email\"]");
        return ForgotEmailAddress;
	}
	
	public Locator ResetLink() {
		Locator ResetLink = page.locator("//button[@id=\"send-reset-link\"]");
		return ResetLink;
	}
	
	public void verifyMessageForgotPassword() {
		Locator MessageResetPassword = page.locator("//p[contains(., \"If this email address has been registered in our store, you will receive a link to reset your password\")]");
		MessageResetPassword.isVisible();
	}
	
}
