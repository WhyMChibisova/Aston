package org.example.module2;

import org.example.module2.model.Book;
import org.example.module2.model.Student;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/main/resources/students.json";

    public static void main(String[] args) {
        Path fileStudents = Paths.get(FILE_NAME);
        List<Student> students = null;

        if (Files.exists(fileStudents) && Files.isRegularFile(fileStudents)) {
            students = StudentReader.readStudentsFromFile(fileStudents);
        } else {
            System.out.println("File not found: " + fileStudents.toAbsolutePath());
            return;
        }

        if (students == null || students.isEmpty()) {
            System.out.println("File is empty");
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
