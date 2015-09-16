package com.capgemini.starterKitSelenium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import com.capgemini.starterKitSelenium.pages.NewAuthorPage;
import com.capgemini.starterKitSelenium.pages.NewBookPage;

public class NewBookFormValidationSeleniumTest extends AbstractSelenium {

	private NewBookPage newBookPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newBookPage = openHomePage().clickFindBook().clickAddBook();
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		newBookPage.clickAddBookButton();

		assertFalse(newBookPage.getNoTitleInfo().getAttribute("class")
				.contains("ng-hide"));
	}

	@Test
	public void shouldCheckIfAuthorIsRequired() {
		newBookPage.setTitle("Test title");
		newBookPage.clickAddBookButton();

		assertTrue(newBookPage.getNoTitleInfo().getAttribute("class")
				.contains("ng-hide"));
		assertFalse(newBookPage.getNoAuthorInfo().getAttribute("class")
				.contains("ng-hide"));
	}

	@Test
	public void shouldAddBook() {
		newBookPage.setTitle("Test title");
		NewAuthorPage newAuthorPage = newBookPage.clickAddAuthorButton();
		newAuthorPage.setFirstName("Jan");
		newAuthorPage.setLastName("Kowalski");
		newAuthorPage.clickAddAuthorButton();

		Integer rowCountBeforeAddingBook = driver.findElements(By.xpath("/html/body/div[2]/div/section/table/tbody/tr")).size();
		
		newBookPage.clickAddBookButton();

		try {
			assertTrue(newBookPage.getNoTitleInfo().getAttribute("class")
					.contains("ng-hide"));
			assertTrue(newBookPage.getNoAuthorInfo().getAttribute("class")
					.contains("ng-hide"));
		} catch (NoSuchElementException e) {
		} catch (StaleElementReferenceException e) {
			/*
			 * The exception is caused by closing modal dialog, it means the
			 * book was successfully added to the library.
			 */
		}
		
		Integer rowCountAfterAddingBook = driver.findElements(By.xpath("/html/body/div[2]/div/section/table/tbody/tr")).size();
		assertEquals(1, rowCountAfterAddingBook - rowCountBeforeAddingBook);
	}
}
