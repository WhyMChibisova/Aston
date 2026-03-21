package org.example.module2.model;

public class Book {
    private String name;
    private String author;
    private int numberOfPages;
    private int yearOfRelease;

    public Book() {
    }

    public Book(String name, String author, int numberOfPages, int yearOfRelease) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s (%d стр.) - %d", name, author, numberOfPages, yearOfRelease);
    }
}
