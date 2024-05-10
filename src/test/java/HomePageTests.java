import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import utils.*;
import pages.*;

import org.junit.jupiter.api.Test;

public class HomePageTests {

	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common;
	
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
	public void getHomePageTitle() {
		HomePage.navigateToHomePage();
		String actualTitle = HomePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "My Store");
		assertThat(page).hasTitle("My Store");
	}
	
	@Test
	public void forgotPassword() {
		HomePage.SigninButton().click();
		Signin.ForgotYourPassword();
		assertThat(page.locator("//li[@class=\"item\"]/p")).hasText("If this email address has been registered in our store, you will receive a link to reset your password at tes@testing.com.");
	}
	
	@Test
	public void searchProductWithoutSignin() {
		HomePage.navigateToHomePage();
		HomePage.SearchField().fill("tshirt");
		HomePage.pressEnterSearch();
		assertThat(page.locator("//h2[@class=\"h3 product-title\"]")).containsText("t-shirt");
		Assert.assertTrue(HomePage.TshirtisVisible());
		
	}
	
	@Test
	public void searchProductWithSignin() {
		HomePage.SigninButton().click();
		try {
			Signin.Login("test@testing.com", "Testovski123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.SearchField().fill("tshirt");
		HomePage.pressEnterSearch();
		assertThat(page.locator("//h2[@class=\"h3 product-title\"]")).containsText("t-shirt");
		Assert.assertTrue(HomePage.TshirtisVisible());
	}

}
