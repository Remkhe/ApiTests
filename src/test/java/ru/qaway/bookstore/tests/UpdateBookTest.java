package ru.qaway.bookstore.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;

public class UpdateBookTest extends BookStoreTestBase {
    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient.create(Book.defaultOf())
                .checkStatusCode(201)
                .getId();
    }

    @Test(dataProvider = "Positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(book);
    }
}