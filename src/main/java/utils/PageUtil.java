package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class PageUtil {

	public static Page createPage(Browser browser) {
		Page page = browser.newPage();
		page.navigate("https://testcommerce.churlinoski.mk/");
		return page;
	}
}
