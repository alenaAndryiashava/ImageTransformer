package com.company.extract;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvReader {
    private final String filePath;
    private final String separator;

    public CsvReader(String filePath, String separator) {
        this.filePath = filePath;
        this.separator = separator;
    }
    public String[][] parse() throws IOException {
        Path path = Paths.get(filePath);
        String[] lines = Files.readAllLines(path).toArray(new String[0]);
        String[][] parsedElements = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            parsedElements[i] = lines[i].split(separator);
        }

        return parsedElements;
    }
}
