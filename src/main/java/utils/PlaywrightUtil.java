package utils;

import com.microsoft.playwright.Playwright;

public class PlaywrightUtil {
	
	public static Playwright createPlaywright() {
		Playwright playwright = Playwright.create();
		return playwright;
	}
}
