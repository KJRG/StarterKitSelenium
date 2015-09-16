package com.capgemini.starterKitSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends AbstractPageObject {
	@FindBy(xpath = "/html/body/div[2]/div/section/button[1]")
	private WebElement searchButton;

	@FindBy(xpath = "/html/body/div[2]/div/section/button[2]")
	private WebElement addBookButton;

	@FindBy(xpath = "/html/body/div[2]/div/section/table/tbody/tr[2]/td[3]/button")
	private WebElement deleteFirstBookButton;

	@FindBy(xpath = "/html/body/div[2]/div/section/table/tbody/tr[2]/td[4]/button")
	private WebElement editFirstBookButton;
	
	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	public BooksPage clickSearch() {
		searchButton.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}

	public NewBookPage clickAddBook() {
		addBookButton.click();
		return PageFactory.initElements(driver, NewBookPage.class);
	}

	public BooksPage clickDeleteFirstBook() {
		deleteFirstBookButton.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}
	
	public EditBookPage clickEditFirstBook() {
		editFirstBookButton.click();
		return PageFactory.initElements(driver, EditBookPage.class);
	}
	
	public WebElement getDeleteFirstBookButton() {
		return deleteFirstBookButton;
	}

	public WebElement getEditFirstBookButton() {
		return editFirstBookButton;
	}
}
