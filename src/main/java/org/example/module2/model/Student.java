package org.example.module2.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Student {
    private final String name;
    private final String group;
    private final List<Book> books;

    @JsonCreator
    public Student(@JsonProperty("name") String name,
                   @JsonProperty("group") String group,
                   @JsonProperty("books") List<Book> books) {
        this.name = name;
        this.group = group;
        this.books = books != null ? List.copyOf(books) : List.of();
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s%nГруппа: %s%nКниги: %s", name, group, books);
    }
}