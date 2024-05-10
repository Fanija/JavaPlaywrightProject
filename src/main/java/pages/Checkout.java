package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.BrowserUtil;
import utils.Common;
import utils.PlaywrightUtil;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;


public class Checkout {
	
	Playwright playwright = PlaywrightUtil.createPlaywright();
	Browser browser = BrowserUtil.createBrowser(playwright);
	Page page;
	Common common = new Common();
	
	HomePage HomePage;
	Signin Signin;
	Register Register;
	PDP PDP;
	PLP PLP;
	Cart Cart;

    public Checkout(Page page) {
        this.page = page;
    }
    
    public void clickOrderasaguest() {
    	Locator Orderasaguest = page.locator("//a[contains(., \"Order as a guest\")]");
    	Orderasaguest.click();
    }
    
    public void clickPersonalInformations() {
    	Locator PersonalInformations = page.locator("//section[@id=\"checkout-personal-information-step\"][contains(., \" Personal Information\")]");
    	PersonalInformations.click();
    }
      
    public void populateNewAddressForm(String newAddress, String newCity) {
    	NewAddressAddress().fill(common.generateRandomNewAddress());
    	NewAddressCity().fill(common.generateRandomNewCity());
    	NewAddressState().selectOption("5");
    	NewAddressZip().fill("98765");
	    NewAddressCountry().selectOption("21");
    }
    
	public void SocialTitlePersonalInformation() {
		Locator SocialTitle = page.locator("//input[@value=\"2\"]");
		SocialTitle.click();
	}
	
	public Locator EmailPersonalInformation() {
		Locator EmailPersonalInformation = page.locator("//form[@class=\"js-customer-form\"]//input[@id=\"field-email\"]");
		return EmailPersonalInformation;
	}
	
	public Locator PasswordPersonalInformation() {
		Locator PasswordPersonalInformation = page.locator("//form[@class=\"js-customer-form\"]//input[@id=\"field-password\"]");
		return PasswordPersonalInformation;
	}
	
	public void checkTermsAndConditionsPersonalInformation() {
		Locator TermsAndConditionsPersonalInformation = page.locator("//input[@name=\"psgdpr\"]");
		TermsAndConditionsPersonalInformation.check();
	}
	
	public void checkCustomerDataPrivacyPersonalInformation() {
		Locator CustomerDataPrivacyPersonalInformation = page.locator("//input[@name=\"customer_privacy\"]");
		CustomerDataPrivacyPersonalInformation.check();
	}
	
	
	public void clickContinuePersonalInformation() {
		Locator ContinuePersonalInformation = page.locator("//button[@data-link-action=\"register-new-customer\"]");
		ContinuePersonalInformation.click();
	}
	
	public void checkShippingAddress() {
		Locator ShippingAddress = page.locator("//input[@name=\"id_address_delivery\" and @value=\"7\"]");
		ShippingAddress.check();
	}
	
	public void EditShippingAddress() {
		Locator EditShippingAddress = page.locator("//footer[@class=\"address-footer\"]/a[contains(., \"Edit\")]");
		EditShippingAddress.click();
	}
	
	
	public void DeleteShippingAddress() {
		Locator DeleteShippingAddress = page.locator("//footer[@class=\"address-footer\"]/a[contains(., \"Delete\")]");
		DeleteShippingAddress.click();
	}
	
	public Locator AddNewAddressButton() {
		Locator AddNewAddressButton = page.locator("//p[@class=\"add-address\"]/a[contains(., \"add new address\")]");
		return AddNewAddressButton;
	}
	
	public Locator NewAddressFirstName() {
		Locator NewAddressFirstName = page.locator("//input[@id=\"field-firstname\"]");
		return NewAddressFirstName;
	}
	
	public Locator NewAddressLastName() {
		Locator NewAddressLastName = page.locator("//input[@id=\"field-lastname\"]");
		return NewAddressLastName;
	}
	
	public Locator NewAddressAddress() {
		Locator NewAddressAddress = page.locator("//input[@id=\"field-address1\"]");
		return NewAddressAddress;
	}
	
	public Locator NewAddressCity() {
		Locator NewAddressCity = page.locator("//input[@id=\"field-city\"]");
		return NewAddressCity;
	}
	
	public Locator NewAddressZip() {
		Locator NewAddressZip = page.locator("//input[@id=\"field-postcode\"]");
		return NewAddressZip;
	}
	
	public Locator NewAddressPhone() {
		Locator NewAddressPhone = page.locator("//input[@id=\"field-phone\"]");
		return NewAddressPhone;
	}
	
	
	public Locator NewAddressState() {
		Locator NewAddressState = page.locator("//select[@id=\"field-id_state\"]");
		return NewAddressState;
	}
	
	public Locator NewAddressCountry() {
		Locator NewAddressCountry = page.locator("//select[@id=\"field-id_country\"]");
		return NewAddressCountry;
	}
	
	public void clickContinueNewAddress() {
		Locator ContinueNewAddress = page.locator("//button[@name=\"confirm-addresses\"]");
		ContinueNewAddress.click();
	}
	
	public void clickDeliveryOption() {
		Locator DeliveryOption = page.locator("id=\"delivery_option_2\"");
		DeliveryOption.click();
	}
	
	public Locator OrderComment() {
		Locator OrderComment = page.locator("//textarea[@id=\"delivery_message\"]");
		return OrderComment;
	}
	
	public void clickContinueDeliveryOption() {
		Locator ContinueDeliveryOption = page.locator("//button[@name=\"confirmDeliveryOption\"]");
		ContinueDeliveryOption.click();
	}
	
	public void clickPaymentOption() {
		Locator PaymentOption = page.locator("//input[@id=\"payment-option-3\"]");
		PaymentOption.click();
	}
	
	public void checkTermsAndCondiitions() {
		Locator TermsAndCondiitions = page.locator("//input[@id=\"conditions_to_approve[terms-and-conditions]\"]");
		TermsAndCondiitions.check();
	}
	
	public Locator PlaceOrderButton() {
		Locator PlaceOrderButton = page.locator("//button[contains(., \"Place order\")]");
		return PlaceOrderButton;
	}
	  
}