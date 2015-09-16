package com.capgemini.starterKitSelenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAuthorPage extends AbstractPageObject {
	@FindBy(xpath = "/html/body/div[6]/div/div/div/form/div[3]/button[1]")
	private WebElement addAuthorButton;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/form/div[2]/input[1]")
	private WebElement firstName;

	@FindBy(xpath = "/html/body/div[6]/div/div/div/form/div[2]/input[2]")
	private WebElement lastName;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/form/div[2]/p[2]")
	private WebElement noFirstNameInfo;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/form/div[2]/p[4]")
	private WebElement noLastNameInfo;
	
	public NewAuthorPage(WebDriver driver) {
		super(driver);
	}

	public NewAuthorPage setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public NewAuthorPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}
	
	public void clickAddAuthorButton() {
		addAuthorButton.click();
	}
	
	public WebElement getNoFirstNameInfo() {
		return noFirstNameInfo;
	}
	
	public WebElement getNoLastNameInfo() {
		return noLastNameInfo;
	}
}
