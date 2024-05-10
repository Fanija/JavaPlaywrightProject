package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

public class PLP {
	//private final Page page;
	
    	Playwright playwright = PlaywrightUtil.createPlaywright();
    	Browser browser = BrowserUtil.createBrowser(playwright);
    	Page page;
    	Common common;
    	
    	HomePage HomePage;
    	Signin Signin;
    	Register Register;
    	PDP PDP;
    	
    	
    	public PLP(Page page) {
    		this.page = page;
    }
   
	public Locator Size() {
		Locator Size = page.locator("//select[@id=\"group_1\"]");
		return Size;
	}
	
	public Locator Color() {
		Locator Color = page.locator("//input[@title=\"White\"]");
		return Color;
	}
	
	public Locator Dimension() {
		Locator Dimension = page.locator("//select[@id=\"group_3\"]");
		return Dimension;
	}
	
	public Locator MoreQuantity() {
		Locator MoreQuantity = page.locator("//button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-up\"]");
		return MoreQuantity;
	}
	
	public Locator LessQuantity() {
		Locator LessQuantity = page.locator("//button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-down\"]");
		return LessQuantity;
	}
	
	public Locator Quantity() {
		Locator Quantity = page.locator("//input[@id=\"quantity_wanted\"]");
		return Quantity;
	}
	
	public Locator AddToCartButton() {
		Locator AddToCartButton = page.locator("//button[contains(., \"Add to cart\")]");
		return AddToCartButton;
	}
	
	public Locator ContinueShoppingButton() {
		Locator ContinueShoppingButton = page.locator("//button[contains(., \"Continue shopping\")]");
		return ContinueShoppingButton;
	}
	
	
	public Locator AddToWishlistButton() {
		Locator AddToWishlistButton = page.locator("//a[@class=\"wishlist-button-add wishlist-button-product\"]");
		return AddToWishlistButton;
	}
	
	public void clickWriteYourReview() {
		Locator WriteYourReview = page.locator("//button[contains(., \"Write your review\")]");
		WriteYourReview.click();
	}
	
	public Locator Title() {
		Locator Title = page.locator("//input[@id=\"comment_title\"]");
		return Title;
	}
	
	public Locator Review() {
		Locator Review = page.locator("//textarea[@id=\"comment_content\"]");
		return Review;
	}
	
	public void clickSend() {
		Locator Send = page.locator("//button[contains(., \"Send\")]");
		Send.click();
	}
	
	public void clickClosePageOK() {
		Locator ClosePageOK = page.locator("//button[contains(., \"OK\")]");
		ClosePageOK.click();
	}
	
	public void clickQuickViewProduct() {
		Locator QuickViewProduct = page.locator("//i[@class=\"material-icons zoom-in\"]");
		QuickViewProduct.click();
	}
	
	public void clickCloseQuickView() {
		Locator CloseQuickView = page.locator("//aside[@id=\"thumbnails\"]");
		CloseQuickView.click();
	}

}
