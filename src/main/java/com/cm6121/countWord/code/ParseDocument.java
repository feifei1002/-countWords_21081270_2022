package com.cm6121.countWord.code;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ParseDocument {

    public List<String> readFile(String... pathDocument) throws IOException {
        StringBuffer sb = new StringBuffer();
        for(String s:pathDocument){
            sb.append(s);
            sb.append("/");
        }

        Path path = Paths.get(System.getProperty("user.home"), sb.toString());
        List<String> strings = Files.readAllLines(path);
        return strings;
    }

    public Document documentParse(List<String> allLines){
        Document document = null;
        String line = allLines.get(1);

        if(allLines.size()>0) {
            String[] split = line.split("\"");
            document = new Document();
            document.setTitle(split[0].substring(0, split[0].length() - 1).trim());
            document.setCreationDate(split[2].substring(1).trim());
            document.setText(split[1]);
        }
        return document;
    }
}
