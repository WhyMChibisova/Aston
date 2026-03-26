package org.example.module2.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.module2.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Student> readStudentsFromJsonFile(final String filename) {
        final Path fileStudents = Paths.get(filename);
        List<Student> students = null;

        if (Files.exists(fileStudents) && Files.isRegularFile(fileStudents)) {
            try (BufferedReader reader = Files.newBufferedReader(fileStudents, StandardCharsets.UTF_8)) {
                students = objectMapper.readValue(reader, new TypeReference<List<Student>>() {});
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("File not found: " + fileStudents.toAbsolutePath());
        }
        return students;
    }
}