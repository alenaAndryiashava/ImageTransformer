package com.company.extract;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataConverter {
    String[][] data;

    public DataConverter(String[][] data) {
        this.data = data;
    }

    public URL[] getUrls() throws MalformedURLException {
        URL[] urls = new URL[data.length];
        for (int i = 0; i < data.length; i++) {
            urls[i]=new URL(data[i][0]);
        }
        return urls;
    }

    public Path[] getPaths(Path dir){
        Path[] paths = new Path[data.length];

        for (int i = 0; i < data.length; i++) {
            Path source = Paths.get(data[i][0]);
            Path target = dir.resolve(source.getFileName());
            paths[i] = target;
        }

        return paths;
    }
}
