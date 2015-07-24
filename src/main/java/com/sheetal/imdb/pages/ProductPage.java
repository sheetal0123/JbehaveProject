package com.sheetal.imdb.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	static XMLRepoParser xmlrepoparser1 = new XMLRepoParser();

	public static void clickSeeFullLink(WebDriver driver) {
		driver.findElement(
				xmlrepoparser1.getByElementFromRepo("ProductPage",
						"SeeFullCastLink")).click();
	}

	public static void verifyThanksCrewNameandRole(WebDriver driver,
			String crewName, String crewRole) {

		Assert.assertTrue(
				"Crew name is not matching with - "+crewName,
				driver.findElement(
						xmlrepoparser1.getByElementFromRepo("ProductPage",
								"ThanksCrewName")).getText()
						.equalsIgnoreCase(crewName));

		Assert.assertTrue(
				"Crew role is not matching with - "+crewRole,
				driver.findElement(
						xmlrepoparser1.getByElementFromRepo("ProductPage",
								"ThanksCrewRole")).getText()
						.equalsIgnoreCase(crewRole));
	}

}
