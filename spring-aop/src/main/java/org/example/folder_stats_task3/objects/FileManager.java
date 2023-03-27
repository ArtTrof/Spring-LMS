package org.example.folder_stats_task3.objects;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
@Component
public class FileManager {

    public Set<String> getExtensionList(String folder) {
        File dir = new File(folder);

        Set<String> extList = new TreeSet<>();

        for (String fileName : Objects.requireNonNull(dir.list())) {

            File file = new File(dir.getAbsolutePath() + "\\" + fileName);

            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1).toLowerCase());
            }
        }

        return extList;

    }

    public Map<String, Integer> getExtensionCount(String folder) {

        File dir = new File(folder);

        Map<String, Integer> map = new HashMap<>();

        for (String ext : getExtensionList(folder)) {
            FilenameFilter filter = new MyFileFilter(ext);
            map.put(ext, Objects.requireNonNull(dir.listFiles(filter)).length);
        }

        return map;

    }

}