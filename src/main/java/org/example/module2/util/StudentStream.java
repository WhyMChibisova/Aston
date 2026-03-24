package org.example.module2.util;

import org.example.module2.model.Book;
import org.example.module2.model.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class StudentStream {
    public static void processStudentData(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("Students is empty");
        } else {
            students.stream()
                    .peek(System.out::println)
                    .map(Student::getBooks)
                    .flatMap(Collection::stream)
                    .sorted(Comparator.comparingInt(Book::getNumberOfPages))
                    .distinct()
                    .filter(book -> book.getYearOfRelease() < 2000)
                    .limit(3)
                    .map(Book::getYearOfRelease)
                    .findFirst()
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Book not found")
                    );
        }
    }
}