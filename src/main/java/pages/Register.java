package pages;

import utils.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;


public class Register {
	
	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	
	//private final Page page;

    public Register(Page page) {
        this.page = page;
    }
    
    public void clickRegister() {
		Locator Register = page.locator("//div[@class=\"no-account\"]/a");
		Register.click();
	} 
    
    public void populateRegisterForm(String firstName, String lastName, String email, String password) {
		SocialTitle().check();
		FirstName().fill(common.generateRandomFirstName());
		LastName().fill(common.generateRandomLastName());
		Email().fill(common.generateRandomEmail());
		Password().fill(common.generateRandomPassword());
		checkSpecialOffers();
		checkTermsAndConditions();
		checkNewsletter();
		checkDataPrivacy();
		//clickSaveRegisterButton();
    }
    

	public Locator SocialTitle() {
		Locator socialTitle = page.locator("//input[@id=\"field-id_gender-1\"]");
		return socialTitle;
	}
	
	public Locator FirstName() {
		Locator FirstName = page.locator("//*[@id=\"field-firstname\"]");
		return FirstName;
	}

	public Locator LastName() {
		Locator LastName = page.locator("//*[@id=\"field-lastname\"]");
		return LastName;
	}
	

	public Locator Email() {
        Locator Email = page.locator("//*[@id=\"field-email\"]");
        return Email;
	}
	
            
    public Locator Password() {
    	 Locator Password = page.locator("//*[@id=\"field-password\"]");
    	 return Password;
    }
    
	public Locator BirthDay() {
		Locator BirthDay = page.locator("//*[@id=\"days\"]");
		return BirthDay;
	}
	
	public Locator BirthMonth() {
		Locator BirthMonth = page.locator("//*[@id=\"months\"]");
		return BirthMonth;
	}
	
	public Locator BirthYear() {
		Locator BirthYear = page.locator("//*[@id=\"years\"]");
		return BirthYear;
	}
	
	public void checkSpecialOffers() {
		Locator specialOffers = page.locator("//input[@name=\"optin\"]");
		specialOffers.check();
	}
	
	public void checkTermsAndConditions() {
		Locator TermsAndConditions = page.locator("//*[@name=\"psgdpr\"]");
		TermsAndConditions.check();
	} 
	
	public void checkNewsletter() {
		Locator newsletter = page.locator("//*[@name=\"newsletter\"]");
		newsletter.check();
	}
	
	public void checkDataPrivacy() {
		Locator DataPrivacy = page.locator("//*[@name=\"customer_privacy\"]");
		DataPrivacy.check();
	}
	
	public void clickSaveRegisterButton() {
		Locator SaveRegisterButton = page.locator("//button[@data-link-action=\"save-customer\"]");
		SaveRegisterButton.click();
	}

}
