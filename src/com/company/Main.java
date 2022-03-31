package com.company;

import com.company.extract.CsvReader;
import com.company.extract.DataConverter;
import com.company.extract.FileDownloader;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        String csvFilePath = args[0];
        String downloadDirectory = args[1];
        CsvReader csvReader = new CsvReader(csvFilePath, ";");
        String[][] data = csvReader.parse();
        DataConverter dataConverter = new DataConverter(data);
        URL[] urls = dataConverter.getUrls();
        Path[] paths = dataConverter.getPaths(Paths.get(downloadDirectory));
        FileDownloader fileDownloader = new FileDownloader();

        for (int i = 0; i < urls.length; i++) {
            fileDownloader.download(urls[i], paths[i]);
        }
    }
}
