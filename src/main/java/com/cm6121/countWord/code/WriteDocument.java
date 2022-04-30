package com.cm6121.countWord.code;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class WriteDocument {

    public static void documentWrite(Document document, Map<String, Integer> writeWords, File file){
        try{
            FileOutputStream outputFile = new FileOutputStream(file, false);
            OutputStreamWriter outputFileWriter = new OutputStreamWriter(outputFile, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(outputFileWriter);
            bw.write(document.getTitle().trim());
            bw.write(",");
            bw.write(document.getCreationDate());
            bw.newLine();

            for(Map.Entry<String, Integer> words: writeWords.entrySet()){
                bw.write(words.getKey().trim());
                bw.write(",");
                bw.write(words.getValue().toString());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void documentWriteAll(String allText, Map<String, Integer> writeWords, File file){
        try{
            FileOutputStream outputFile = new FileOutputStream(file, false);
            OutputStreamWriter outputFileWriterAll = new OutputStreamWriter(outputFile, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(outputFileWriterAll);
            for(Map.Entry<String, Integer> words: writeWords.entrySet()){
                bw.write(words.getKey().trim());
                bw.write(",");
                bw.write(words.getValue().toString());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
