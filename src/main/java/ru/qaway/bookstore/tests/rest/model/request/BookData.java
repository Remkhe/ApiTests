package ru.qaway.bookstore.tests.rest.model.request;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import ru.qaway.bookstore.tests.rest.enums.Category;

public class BookData {
    @DataProvider
    public static Object[][] Positive(){
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
    @DataProvider
    public static Object[][] createBooksNegative() {
        return new Object[][] {
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                { Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},
                { Book.defaultOf().setPrice(-1)},
                { Book.defaultOf().setCount(-1)},
                { Book.defaultOf().setCategory(Category.Unknown)},
        };
    }
}

