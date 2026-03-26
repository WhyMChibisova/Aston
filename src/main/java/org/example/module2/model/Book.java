package org.example.module2.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private final String name;
    private final String author;
    private final int numberOfPages;
    private final int yearOfRelease;

    @JsonCreator
    public Book(@JsonProperty("name") String name,
                @JsonProperty("author") String author,
                @JsonProperty("numberOfPages") int numberOfPages,
                @JsonProperty("yearOfRelease") int yearOfRelease) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s (%d стр.) - %d", name, author, numberOfPages, yearOfRelease);
    }
}