package com.capgemini.starterKitSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPageObject{
	@FindBy(xpath = "/html/body/div[2]/div/div/div/p[1]/a")
	private WebElement books;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9000");
	}
	
	public BooksPage clickFindBook() {
		books.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}
	
}
