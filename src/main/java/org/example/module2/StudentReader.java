package org.example.module2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.module2.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StudentReader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Student> readStudentsFromFile(Path path) {
        List<Student> students = null;

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            students = objectMapper.readValue(reader, new TypeReference<List<Student>>() {});
        } catch (IOException e) {
            System.out.println(e);
        }
        return students;
    }
}