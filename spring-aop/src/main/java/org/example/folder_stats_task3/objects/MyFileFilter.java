package org.example.folder_stats_task3.objects;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
public class MyFileFilter implements FilenameFilter {
    private final String extension;

    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(File file, String name) {
        return name.toUpperCase().endsWith("." + extension.toUpperCase());
    }
}
