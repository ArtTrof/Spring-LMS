package org.example.speed_test_task4.objects;

import java.io.File;

public class MyFileFilter {
    private String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(File file, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }

}
