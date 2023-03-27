package org.example.speed_test_task5.objects;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {
    private String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(File file, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }

}
