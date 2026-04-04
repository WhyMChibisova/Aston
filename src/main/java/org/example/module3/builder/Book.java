package org.example.module3.builder;

public class Book {
    private final String name;
    private final String author;
    private final int numberOfPages;
    private final int yearOfRelease;

    private Book(final BookBuilder bookBuilder) {
        this.name = bookBuilder.name;
        this.author = bookBuilder.author;
        this.numberOfPages = bookBuilder.numberOfPages;
        this.yearOfRelease = bookBuilder.yearOfRelease;
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

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {
        private String name;
        private String author;
        private int numberOfPages;
        private int yearOfRelease;

        public BookBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder numberOfPages(int numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public BookBuilder yearOfRelease(int yearOfRelease) {
            this.yearOfRelease = yearOfRelease;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s (%d стр.) - %d", name, author, numberOfPages, yearOfRelease);
    }
}