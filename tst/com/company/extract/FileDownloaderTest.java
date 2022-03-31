package com.company.extract;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileDownloaderTest {

    @Test
    void testDownload() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("data/test.jpg");
        File tempFile = File.createTempFile("copy", ".jpg");
        tempFile.deleteOnExit();
        Path target = Paths.get(tempFile.getAbsolutePath());

        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.download(url, target);

        byte[] expected = Files.readAllBytes(Path.of(url.getPath()));
        byte[] actual = Files.readAllBytes(target);

        assertArrayEquals(expected, actual);
    }
}