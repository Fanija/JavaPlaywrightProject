package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;

public class PDP {
	
	//private final Page page;
	
	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common;
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PLP PLP;

    public PDP(Page page) {
        this.page = page;
    }
    
	public Locator openProduct(String productName) {
		Locator ProductName = page.locator("//a[contains(., \""+productName+"\")]");
		return ProductName;
	}
	
	public Locator openCategory( String category) {
		Locator CategoryName = page.locator("//a[contains(., \""+category+"\")]");
		return CategoryName;
	}
	
	public Locator openSubCategory( String subcategory) {
		Locator SubCategoryName = page.locator("//a[contains(., \""+subcategory+"\")]");
		return SubCategoryName;
	}
	
}
