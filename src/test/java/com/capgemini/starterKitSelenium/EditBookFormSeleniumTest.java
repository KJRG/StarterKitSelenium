package com.capgemini.starterKitSelenium;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.starterKitSelenium.pages.BooksPage;
import com.capgemini.starterKitSelenium.pages.EditBookPage;
import com.capgemini.starterKitSelenium.pages.NewAuthorPage;
import com.capgemini.starterKitSelenium.pages.NewBookPage;

public class EditBookFormSeleniumTest extends AbstractSelenium {

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
	}
	
	@Test
	public void shouldEditFirstBookTitle() {
		
		/*
		 * Perform empty search to find all books.
		 */
		booksPage.clickSearch();
		EditBookPage editBookPage = booksPage.clickEditFirstBook();
		
		editBookPage.setTitle("Test");
		editBookPage.clickEditBookButton();
	}
}
