package com.cm6121.countWord.code;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
            document.setText(split[1].trim());
            document.setCreationDate(split[2].substring(1).trim());
        }
        else{
            System.out.println("Problems with parsing the file");
        }
        return document;
    }

    public TreeMap<String, Integer> readNumberWords(String wordToRead, String parameterSplit){
        TreeMap<String, Integer> noOfWords = new TreeMap<>();
        wordToRead = wordToRead.replaceAll("\\p{Punct}", " ").trim();
        wordToRead = wordToRead.replaceAll("\\s{1}", " ");
        wordToRead = wordToRead.replaceAll("[^a-zA-Z]", " ");
        wordToRead = wordToRead.toLowerCase();
        String[] words = wordToRead.split(parameterSplit);

        for (String w:words){
            if(w.length()>1){
                if(noOfWords.containsKey(w)){
                    noOfWords.put(w, noOfWords.get(w)+1);
                }
                else{
                    noOfWords.put(w, 1);
                }
            }
        }
        return noOfWords;
    }

    public <K,V> void printWords(Map<K,V> map){
        for(Map.Entry<K,V> entry:map.entrySet()){

            System.out.println("Key: " + entry.getKey()+" ;"+" Value: "+entry.getValue());
        }
    }
}
