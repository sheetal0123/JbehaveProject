package com.sheetal.imdb.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	static XMLRepoParser xmlrepoparser = new XMLRepoParser();

	public static void searchFor(WebDriver driver, String searchString) {
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "SearchBox"))
				.clear();
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage", "SearchBox"))
				.sendKeys(searchString);
		driver.findElement(
				xmlrepoparser.getByElementFromRepo("HomePage",
						"SearchBoxButton")).click();
	}

}
