package ru.qaway.bookstore.tests.rest.model;

import lombok.*;
import ru.qaway.bookstore.tests.rest.enums.Category;
@Data
public class Book {
    private String title;
    private String description;
    private String author;
    private Integer price;
    private Integer count;
    private Category category;


}
