package com.sheetal.imdb.jbehave;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.Named;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sheetal.imdb.pages.HomePage;
import com.sheetal.imdb.pages.ProductPage;
import com.sheetal.imdb.pages.SearchPage;

public class IMDbSteps {
	WebDriver driver;

	@Given("user is on url <url>")
	public void openHomePage(@Named("url") String url) {
		 driver = new FirefoxDriver();

//      To Run with Chrome driver
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\sheetalsingh\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("user searched for <searchString> on page")
	public void searchForKeyword(@Named("searchString") String searchString) {
		HomePage.searchFor(driver, searchString);
	}

	@When("user click on <link1> on the search page")
	public void selectLink(@Named("link1") String link1) {
		SearchPage.clickLinkText(driver, link1);
	}

	@When("user select see full cast link on the product page")
	public void selectSeeFullLink() {
		ProductPage.clickSeeFullLink(driver);
	}

	@Then("user sees <message1> and <message2> on the page")
	public void verifyCrewNameandRole(@Named("message1") String message1,
			@Named("message2") String message2) {
		ProductPage.verifyThanksCrewNameandRole(driver, message1, message2);
		driver.quit();
	}

}
