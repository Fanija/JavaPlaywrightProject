package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserUtil {
	
	public static Browser createBrowser(Playwright playwright) {
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		return browser;
	}

}
