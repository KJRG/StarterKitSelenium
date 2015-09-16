package com.capgemini.starterKitSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBookPage extends AbstractPageObject {
	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[3]/button[2]")
	private WebElement addBookButton;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[2]/input")
	private WebElement title;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[3]/button[1]")
	private WebElement addAuthorButton;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[2]/p[2]")
	private WebElement noTitleInfo;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[2]/p[4]")
	private WebElement noAuthorInfo;

	public NewBookPage(WebDriver driver) {
		super(driver);
	}

	public NewBookPage setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public void clickAddBookButton() {
		addBookButton.click();
	}

	public NewAuthorPage clickAddAuthorButton() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, NewAuthorPage.class);
	}
	
	public WebElement getNoTitleInfo() {
		return noTitleInfo;
	}
	
	public WebElement getNoAuthorInfo() {
		return noAuthorInfo;
	}
}
