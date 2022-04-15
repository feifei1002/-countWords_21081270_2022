package com.cm6121.countWord.app;


import com.cm6121.countWord.code.CreateFile;
import com.cm6121.countWord.code.Document;
import com.cm6121.countWord.code.ParseDocument;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main (String[] args) throws IOException {
        String documentToRead = ClassLoader.getSystemClassLoader().getResource("FolderDocumentsToRead").getPath();
        System.out.println("The counting words application");
        System.out.println(documentToRead);

        ParseDocument pd = new ParseDocument();
        List<String> documentLines = pd.readFile("Desktop", "DocumentsToParse", "ATale.csv");
        Document document = pd.documentParse(documentLines);
        System.out.println("The title of the file is "+document.getTitle());
        System.out.println("The normalised date of the file is "+document.getCreationDate());
        HashMap<String, Integer> stringIntegerHashMap = pd.readNumberWords(document.getText(), " ");

        pd.printMap(stringIntegerHashMap);

        CreateFile cf = new CreateFile();
        cf.fileCreate();
    }
}
