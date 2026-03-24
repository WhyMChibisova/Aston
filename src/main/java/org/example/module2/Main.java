package org.example.module2;

import org.example.module2.model.Student;
import org.example.module2.util.StudentReader;
import org.example.module2.util.StudentStream;

import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/main/resources/students.json";

    public static void main(String[] args) {
        List<Student> students = StudentReader.readStudentsFromJsonFile(FILE_NAME);

        StudentStream.processStudentData(students);
    }
}