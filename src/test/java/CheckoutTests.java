import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.Cart;
import pages.Checkout;
import pages.HomePage;
import pages.PDP;
import pages.PLP;
import pages.Register;
import pages.Signin;
import utils.BrowserUtil;
import utils.PageUtil;
import utils.PlaywrightUtil;
import utils.Common;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.Random;


class CheckoutTests {

	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common;
	Random rand = new Random();
	
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	Cart Cart;
	PLP PLP;
	PDP PDP;
	Checkout Checkout;
	
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
		Cart = new Cart(page);
		PLP = new PLP(page);
		PDP = new PDP(page);
		Checkout = new Checkout(page);
		
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
	
	@Test
	public void SigninUserandCheckoutProduct() {
		HomePage.navigateToHomePage();
		
		if (HomePage.getHomePageTitle().equals("My Store")) {
            System.out.println("Element does not exist.");
        } else {
            System.out.println("Element exists.");
        }
		HomePage.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		//assertThat(page).hasTitle("View my customer account");
		assertThat(page.locator("//a[@class=\"account\"][@title= \"View my customer account\"]")).isVisible();
		
		PDP.openCategory("Clothes").click();
		PDP.openSubCategory("Men");
        PDP.openProduct("Hummingbird printed t-shirt").click();
        PLP.Size().selectOption("1");
        PLP.Quantity().fill("4");
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		//assert (page.locator("//a[contains(., \"Hummingbird printed t-shirt\")]").isVisible());
		
		Cart.IncreaseQuantityFromCart().click();
		//assertThat(page.locator("//input[@type=\"number\"]")).hasValue("5");
		Cart.ProceedToCheckout().click();
		Checkout.clickContinueNewAddress();
		Checkout.OrderComment().fill("This is my order");
		Checkout.clickContinueDeliveryOption();
		Checkout.clickPaymentOption();
		Checkout.checkTermsAndCondiitions();
		Checkout.PlaceOrderButton().click();
		//assertThat(page).hasTitle("Order confirmation");
		//assertThat(page.getByText("YOUR ORDER IS CONFIRMED")).isVisible();
		
		HomePage.LogoutButton().click();
		//assertThat(page).hasTitle("Log in to your customer account");
		//assertThat(page.getByText("Sign in")).isVisible();
	}
	
	@Test
	
	public void CheckoutProductWithoutLogin() {
		HomePage.navigateToHomePage();
		if (HomePage.getHomePageTitle().equals("My Store")) {
            System.out.println("Element does not exist.");
        } else {
            System.out.println("Element exists.");
        }
		
		PDP.openCategory("Art").click();
        PDP.openProduct("Today is a good day Framed...").click();
        PLP.Dimension().click();
        PLP.Quantity().fill("4");
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		Cart.ProceedToCheckout().click();
		Checkout.clickOrderasaguest();
		//assertThat (page.locator("//a[contains(., \"Today is a good day Framed...\")]")).isVisible();
		Register.populateRegisterForm(common.generateRandomFirstName(), common.generateRandomLastName(), common.generateRandomEmail(), common.generateRandomPassword());
		Checkout.clickContinuePersonalInformation();
		//assertThat(page).hasTitle("Addresses");
		
		Checkout.populateNewAddressForm(common.generateRandomNewAddress(), common.generateRandomNewCity());
		Checkout.clickContinueNewAddress();
		//assertThat(page).hasTitle("Shipping Method");
		
		Checkout.OrderComment().fill("My Order Comment");
		Checkout.clickContinueDeliveryOption();
		//assertThat(page).hasTitle("Payment");
		
		Checkout.clickPaymentOption();
		Checkout.checkTermsAndCondiitions();
		Checkout.PlaceOrderButton().click();
		assertThat(page).hasTitle("Order confirmation");
		HomePage.LogoutButton().click();
		
	
}

	
}
