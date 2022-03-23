package com.company.extract;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {
    @Test
    void testParse() throws IOException {
        CsvReader csvReader = new CsvReader("data/ImageList.csv", ";");
        String[][] actual = csvReader.parse();

        String[][] expected = {
                {"https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/1a.jpg","GRAYSCALE"},
                {"https://s3-eu-west-1.amazonaws.com/lukaroundimg/beelitz2017/9a.jpg","THUMBNAIL"},
                {"http://s3-eu-west-1.amazonaws.com/lukaroundimg/zirm2/1.jpg","PREVIEW"}
        };

        assertArrayEquals(expected, actual);
    }
}