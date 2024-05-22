package com.csc340.restapidemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtility {
    private static final String FILE_PATH = "students.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<Integer, Student> readStudentsFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new HashMap<>();
            }
            return objectMapper.readValue(file, new TypeReference<Map<Integer, Student>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public static void writeStudentsToFile(Map<Integer, Student> studentDatabase) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), studentDatabase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
