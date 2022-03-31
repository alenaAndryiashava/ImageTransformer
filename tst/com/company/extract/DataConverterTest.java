package com.company.extract;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterTest {
    static String[][] data = {
            {"https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg","GRAYSCALE"},
            {"https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/9a.jpg","THUMBNAIL"},
            {"http://s3-eu-west-1.amazonaws.com/lukaroundimg/zirm2/1.jpg","PREVIEW"}
        };

    @Test
    void testGetUrls() throws MalformedURLException {
        DataConverter dataConverter = new DataConverter(data);

        URL[] expected = {
                new URL(data[0][0]),
                new URL(data[1][0]),
                new URL(data[2][0])
        };

        URL[] actual = dataConverter.getUrls();

        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetPaths() {
        Path dir = Paths.get("data/download");
        DataConverter dataConverter = new DataConverter(data);

        Path[] actual = dataConverter.getPaths(dir);

        Path[] expected = {
                Paths.get("data/download/1a.jpg"),
                Paths.get("data/download/9a.jpg"),
                Paths.get("data/download/1.jpg"),
        };

        assertArrayEquals(expected, actual);
    }
}