package com.capgemini.starterKitSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditBookPage extends AbstractPageObject {
	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[3]/button[1]")
	private WebElement editBookButton;

	@FindBy(xpath = "/html/body/div[5]/div/div/div/form/div[2]/input")
	private WebElement title;
	
	public EditBookPage(WebDriver driver) {
		super(driver);
	}

	public void clickEditBookButton() {
		editBookButton.click();
	}
	
	public EditBookPage setTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
		return this;
	}
}
