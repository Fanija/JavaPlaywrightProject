import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.Cart;
import pages.HomePage;
import pages.PDP;
import pages.PLP;
import pages.Register;
import pages.Signin;
import utils.BrowserUtil;
import utils.PageUtil;
import utils.PlaywrightUtil;

class CartTests {
	
	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	Cart Cart;
	PLP PLP;
	PDP PDP;
	
	
	@BeforeEach
	public void setUp() {
		page = PageUtil.createPage(browser);
		HomePage = new HomePage(page);
		Signin = new Signin(page);
		Register = new Register(page);
		Cart = new Cart(page);
		PLP = new PLP(page);
		PDP = new PDP(page);
		
	}
	
	@AfterEach
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}

	@Test
	public void AddProducInCart() {
                        HomePage.SigninButton().click();
                        Signin.Login("test@testing.com", "Testovski123");
                        assertThat(page.locator("//a[@class=\"account\"][@title= \"View my customer account\"]")).isVisible();
                        PDP.openCategory("Clothes").click();
                        PDP.openProduct("Hummingbird printed t-shirt").click();
                        PLP.Size().selectOption("1");
                        PLP.Color().click();
                        PLP.Quantity().fill("4");
						PLP.AddToCartButton().click();
						PLP.ContinueShoppingButton().click();
						//assertThat(page.locator("//a[contains(., \"Hummingbird printed t-shirt\")]")).isVisible();
						HomePage.LogoutButton();
                        
	} 
	
	@Test	
	public void AddProducInCartWithoutLogin() {
							PDP.openCategory("Clothes").click();
					        PDP.openProduct("Hummingbird printed sweater").click();
					        PLP.Size().selectOption("2");
					        PLP.Quantity().fill("2");
							PLP.AddToCartButton().click();
							PLP.ContinueShoppingButton().click();
							//assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]")).isVisible();
							HomePage.SigninButton().click();
							assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
                        
    }
	
	@Test
	public void AddProducInCartWithoutSelectingColor() {
		
		HomePage.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		PDP.openCategory("Home Accessories").click();
        PDP.openProduct("Mountain fox cushion").click();
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Mountain fox cushion\")]").isVisible());
		HomePage.LogoutButton().click();
		assert (page.locator("//a[contains(., \"Log in to your customer account\")]")).getByTitle("Log in to your customer account") != null;
	}
	
	
	@Test
	public void AddProducInCartWithoutSelectingQuantityWithoutLoginAndProceedToCheckoutAndLogoutAndLoginAndProceedToCheckout() {
		
		PDP.openCategory("Art").click();
		PDP.openProduct("Mountain fox - Vector graphics").click();
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Mountain fox - Vector graphics\")]").isVisible());
		HomePage.SigninButton().click();
		Signin.Login("test@testing.com", "Testovski123");
		assert (page.locator("//a[@class=\"account\"]")).getByTitle("View my customer account") != null;
		Cart.ProceedToCheckout().click();
		assert (page.locator("//h1[contains(., \"Personal Information\")]").isVisible());
	}
	
	@Test
	public void AddProductinCartAndDeleteProductFomCart() {
		
		PDP.openCategory("Clothes").click();
		PDP.openSubCategory("Men");
        PDP.openProduct("Hummingbird printed sweater").click();
        PLP.Size().selectOption("2");
        PLP.Quantity().fill("4");
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		assertThat(page.locator("//a[contains(., \"Hummingbird printed sweater\")]")).isVisible();
		//assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		Cart.RemoveProduct().click();
		assertThat(page.locator("//div[@class=\"card cart-container\"][contains(., \"There are no more items in your cart\")]")).isVisible();
		
	}
	
	@Test
	public void AddProductinCartAndIncreaseQuantity() {
		
		PDP.openCategory("Clothes").click();
		PDP.openSubCategory("Men");
		PDP.openProduct("Hummingbird printed sweater").click();
        PLP.Size().selectOption("3");
        PLP.Quantity().fill("2");
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		Cart.IncreaseQuantityFromCart().click();
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("3");
	}
	
	@Test
	public void AddProductinCartAndDecreaseQuantity() {
		PDP.openCategory("Clothes").click();
		PDP.openProduct("Hummingbird printed sweater").click();
        PLP.Size().selectOption("2");
        PLP.Quantity().fill("3");
		PLP.AddToCartButton().click();
		Cart.ProceedToCheckout().click();
		assert (page.locator("//a[contains(., \"Hummingbird printed sweater\")]").isVisible());
		Cart.DecreaseQuantityFromCart().click();
		assertThat(page.locator("//input[@type=\"number\"]")).hasValue("2");
	}
}
