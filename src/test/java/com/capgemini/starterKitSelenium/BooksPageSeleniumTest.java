package com.capgemini.starterKitSelenium;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.starterKitSelenium.pages.BooksPage;
import com.capgemini.starterKitSelenium.pages.NewAuthorPage;
import com.capgemini.starterKitSelenium.pages.NewBookPage;

public class BooksPageSeleniumTest extends AbstractSelenium {

	private BooksPage booksPage;
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
		booksPage = openHomePage().clickFindBook();
		
		/*
		 * Make sure there is at least 1 book in library.
		 */
		NewBookPage newBookPage = booksPage.clickAddBook();
		newBookPage.setTitle("Test title");
		NewAuthorPage newAuthorPage = newBookPage.clickAddAuthorButton();
		newAuthorPage.setFirstName("Jan");
		newAuthorPage.setLastName("Kowalski");
		newAuthorPage.clickAddAuthorButton();
		newBookPage.clickAddBookButton();
	}
	
	@Test
	public void deleteBookButtonShouldBeEnabled() {
		
		/*
		 * Perform empty search.
		 */
		booksPage.clickSearch();
		
		assertTrue(booksPage.getDeleteFirstBookButton().isEnabled());
	}

	@Test
	public void editBookButtonShouldBeEnabled() {
		
		/*
		 * Perform empty search.
		 */
		booksPage.clickSearch();
		
		assertTrue(booksPage.getEditFirstBookButton().isEnabled());
	}
	
	@Test
	public void shouldDeleteFirstBook() {
		
		/*
		 * Perform empty search.
		 */
		booksPage.clickSearch();
		
		booksPage.clickDeleteFirstBook();
	}
}
