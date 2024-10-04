package ru.qaway.bookstore.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.client.TestClient;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;

import static io.restassured.RestAssured.given;

public class CreateBookTest extends BookStoreTestBase{
    @Test(dataProvider = "createBooks", dataProviderClass = BookData.class)
    public void testCreateBook(Book book){

       BookValidatableResponse response = testClient.create(book).checkStatusCode(201).
                checkIdNotNull().
                checkLastUpdated().
                checkBook(book);
       testClient.read(response.getId())
               .checkStatusCode(200)
               .checkId(response.getId())
               .checkLastUpdated()
               .checkBook(book);

    }
    @DataProvider
    public Object[][] createBooks(){
        return new Object[][]{
                {Book.defaultOf()},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},
                { Book.defaultOf().setPrice(0) },
                { Book.defaultOf().setCount(0) },
                { Book.defaultOf().setCategory(Category.Detective) },
                { Book.defaultOf().setCategory(Category.Fiction) },
                { Book.defaultOf().setCategory(Category.Horror) },
                { Book.defaultOf().setCategory(Category.Thriller) },
                // title min = 3
        // title max = 256
        // description min = 3
        // description max = 512
        // author min = 3
        // author max = 100
        // price >= 0
        // count >= 0
        // categories from enum : [ Adventures, Detective, Fiction, Horror, Thriller ]

        };
    }
}
