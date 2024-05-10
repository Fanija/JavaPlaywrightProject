import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import utils.*;
import pages.*;


import org.junit.jupiter.api.Test;

public class SigninTests {

	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	@Test
	public void login(){
		HomePage.SigninButton().click();
		assertThat(page).hasTitle("Login");
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		//assertThat(page).hasTitle("View my customer account");
		
	}
	
	@Test
	public void loginWithEmptyPassword() {
		HomePage.SigninButton().click();
		assertThat(page).hasTitle("Login");
//		Signin.LoginWithEmptyPassword();
		Signin.Login("test@testing.com", "");
		assert (page.locator("//a[contains(., \"Forgot your password?\")]")).getByText("Forgot your password?") != null;
		//assertThat(page.getByText("Please fill out this field.")).isVisible();
} 
	
	@Test
    public void logout() {
		HomePage.SigninButton().click();
		assertThat(page).hasTitle("Login");
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
	    HomePage.LogoutButton().click();
	    assert (page.locator("//a[contains(., \"Log in to your customer account\")]")).getByTitle("Log in to your customer account") != null;
	    //assertThat(page.getByText("Sign in")).isVisible();
}		
}