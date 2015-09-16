package com.capgemini.starterKitSelenium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import com.capgemini.starterKitSelenium.pages.NewAuthorPage;
import com.capgemini.starterKitSelenium.pages.NewBookPage;

public class NewAuthorFormValidationSeleniumTest extends AbstractSelenium {

	private NewBookPage newBookPage;
	private NewAuthorPage newAuthorPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newBookPage = openHomePage().clickFindBook().clickAddBook();
		newAuthorPage = newBookPage.clickAddAuthorButton();
	}

	@Test
	public void shouldCheckIfFirstNameIsRequired() {
		newAuthorPage.setLastName("Test last name");
		newAuthorPage.clickAddAuthorButton();
		
		assertTrue(newAuthorPage.getNoLastNameInfo().getAttribute("class").contains("ng-hide"));
		assertFalse(newAuthorPage.getNoFirstNameInfo().getAttribute("class").contains("ng-hide"));
	}

	@Test
	public void shouldCheckIfLastNameIsRequired() {
		newAuthorPage.setFirstName("Test first name");
		newAuthorPage.clickAddAuthorButton();

		assertTrue(newAuthorPage.getNoFirstNameInfo().getAttribute("class").contains("ng-hide"));
		assertFalse(newAuthorPage.getNoLastNameInfo().getAttribute("class").contains("ng-hide"));
	}

	@Test
	public void shouldAddAuthor() {
		newAuthorPage.setFirstName("Test first name");
		newAuthorPage.setLastName("Test last name");

		Integer rowCountBeforeAddingAuthor = driver.findElements(By.xpath("/html/body/div[5]/div/div/div/form/div[2]/table/tbody/tr")).size();

		newAuthorPage.clickAddAuthorButton();

		try {
			assertTrue(newAuthorPage.getNoFirstNameInfo().getAttribute("class").contains("ng-hide"));
			assertTrue(newAuthorPage.getNoLastNameInfo().getAttribute("class").contains("ng-hide"));
		} catch (NoSuchElementException e) {
		} catch (StaleElementReferenceException e) {
			/*
			 * The exception is caused by closing modal dialog, it means the
			 * author was successfully added to the book.
			 */
		}
		
		Integer rowCountAfterAddingAuthor = driver.findElements(By.xpath("/html/body/div[5]/div/div/div/form/div[2]/table/tbody/tr")).size();
		
		assertEquals(1, rowCountAfterAddingAuthor - rowCountBeforeAddingAuthor);
	}
}
