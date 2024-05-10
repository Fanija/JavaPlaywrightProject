import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import utils.*;
import pages.*;


public class RegisterTests {

	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common = new Common();
	
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PDP PDP;
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
		PDP = new PDP(page);
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	
	@Test
	public void successfulRegisterTest() {
		HomePage.SigninButton().click();
		Register.clickRegister();
		Register.populateRegisterForm(common.generateRandomFirstName(), common.generateRandomLastName(), common.generateRandomEmail(), common.generateRandomPassword());
		Register.clickSaveRegisterButton();
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
	}
	
	@Test
	public void unsuccessfulRegisterTest() {
		HomePage.SigninButton().click();
		Register.clickRegister();
		Register.populateRegisterForm("Test", "Testing", "test@testing.com", "Testovski123");
		Register.clickSaveRegisterButton();
		assert (page.locator("//li[@class=\"alert alert-danger\"]")).getByText("The email is already used, please choose another one or sign in") != null;
	}
	
}
