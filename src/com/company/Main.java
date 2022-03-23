package com.company;

import com.company.extract.CsvReader;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        CsvReader csvReader = new CsvReader(args[0], ";");
        String[][] data = csvReader.parse();
        for (String[] elements : data) {
            System.out.println(Arrays.toString(elements));
        }
    }
}
