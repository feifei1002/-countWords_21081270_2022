package com.cm6121.countWord.code;

import java.io.*;
import java.util.Map;

public class WriteDocument {

    public static void documentWrite(Document document, Map<String, Integer> writeWords, File file){
        try{
            FileOutputStream outputFile = new FileOutputStream(file, false);
            OutputStreamWriter outputFileWriter = new OutputStreamWriter(outputFile, "UTF-16");
            BufferedWriter bw = new BufferedWriter(outputFileWriter);
            bw.write(document.getTitle());
            bw.newLine();
            bw.write(document.getCreationDate());
            bw.newLine();

            for(Map.Entry<String, Integer> words: writeWords.entrySet()){
                bw.write(words.getKey());
                bw.write(words.getValue().toString());
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
