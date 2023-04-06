package org.example.speed_test_task5.objects;

import org.example.speed_test_task5.custom_annotations.ShowRes;
import org.example.speed_test_task5.custom_annotations.ShowTime;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Component
public class MyFileManager {

    @ShowTime
    @ShowRes
    public Set<String> getExtensionList(String folder) {
        File dir = new File(folder);
        Set<String> extList = new TreeSet<String>();
        for (String fileName : dir.list()) {
            File file = new File(dir.getAbsolutePath() + "\\" + fileName);
            int i = fileName.lastIndexOf(".");
            if (file.isFile() && i != -1) {
                extList.add(fileName.substring(i + 1, fileName.length()).toLowerCase());
            }
        }
        return extList;
    }

    @ShowRes
    public Map<String, Integer> getExtensionCount(String folder) {
        File dir = new File(folder);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String ext : getExtensionList(folder)) {
            FilenameFilter filter = new MyFileFilter(ext);
            map.put(ext, dir.listFiles(filter).length);
        }
        return map;

    }
}