package org.robatipoor;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

    public static void main(String[] args) throws IOException {
        // Example 1
        // List<Path> paths = getJsonDictionaryPaths(Paths.get("../../Dictionaries"));
        // for (Path path : paths) {
        // var json = Files.readString(path);
        // var dic = jsonToDictionary(json);
        // for (Word w : dic.getWords()) {
        // // ...
        // }
        // }
        // // Example 2 search with index
        var key = "example";
        Map<String, List<String>> dics = getIndex(Paths.get("../../Dictionaries"));
        var list = dics.get(String.valueOf(key.charAt(0)).toUpperCase());
        for (String path : list) {
            String json = Files.readString(Paths.get(path));
            Dictionary dic = jsonToDictionary(json);
            for (Word w : dic.getWords()) {
                if (w.getEnglishWord().matches("(?i).*(" + key + ").*")) {
                    for (String mean : w.getMeanings()) {
                        System.out.println(mean);
                    }
                }
            }
        }
    }

    public static List<Path> getJsonDictionaryPaths(Path path) throws IOException {
        return Files.walk(path).filter((p) -> p.toString().endsWith("json"))
                .sorted((o1, o2) -> o1.toAbsolutePath().getFileName().compareTo(o2.toAbsolutePath().getFileName()))
                .collect(Collectors.toList());
    }

    public static Dictionary jsonToDictionary(String json) {
        var gson = new Gson();
        Dictionary dictionary = gson.fromJson(json, Dictionary.class);
        return dictionary;
    }

    public static Map<String, List<String>> getIndex(Path pathDictionarys) throws IOException {
        var indexPath = Paths.get(pathDictionarys.toString(), "index.json");
        if (Files.exists(indexPath)) {
            var json = Files.readString(indexPath);
            var gson = new Gson();
            Type type = new TypeToken<Map<String, List<String>>>() {
            }.getType();
            Map<String, List<String>> map = gson.fromJson(json, type);
            return map;
        }
        List<Path> paths = getJsonDictionaryPaths(pathDictionarys);
        Map<String, List<String>> map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            List<String> list = new ArrayList<>();
            for (Path path : paths) {
                if (path.getFileName().toString().toUpperCase().equals(String.valueOf(c) + ".JSON")) {
                    list.add(path.toAbsolutePath().toString());
                }
            }
            map.put(String.valueOf(c), list);
        }
        var gson = new GsonBuilder().create();
        var json = gson.toJson(map);
        Files.write(indexPath, json.getBytes(), StandardOpenOption.CREATE);
        return map;
    }
}
