package com.sheetal.imdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	static XMLRepoParser xmlrepoparser = new XMLRepoParser();

	public static void clickLinkText(WebDriver driver, String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

}
