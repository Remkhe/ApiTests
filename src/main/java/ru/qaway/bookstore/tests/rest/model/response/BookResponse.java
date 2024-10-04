package ru.qaway.bookstore.tests.rest.model;

import lombok.*;

import java.time.OffsetDateTime;
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse extends Book{
    private Integer id;
    private OffsetDateTime lastUpdated;
}
