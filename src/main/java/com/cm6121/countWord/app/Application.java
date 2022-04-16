package com.cm6121.countWord.app;


import com.cm6121.countWord.code.CreateFile;
import com.cm6121.countWord.code.Document;
import com.cm6121.countWord.code.ParseDocument;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main (String[] args) throws IOException {
        String documentToRead = ClassLoader.getSystemClassLoader().getResource("FolderDocumentsToRead").getPath();
        System.out.println("The counting words application");
        System.out.println(documentToRead);

        File file = new File("C:\\Users\\c21081270\\Desktop\\ASE Year 1\\Java Assessment 2\\cm6121_assessment_2_start\\build\\resources\\main\\FolderDocumentsToRead");
        String[] listFile = file.list();
        System.out.println("The number of documents in the folder is "+listFile.length);
        for (String name : listFile) {
                System.out.println("The file name is "+name);
            }

        ParseDocument pd = new ParseDocument();
        List<String> documentLines = pd.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", "ATale.csv");
        Document document = pd.documentParse(documentLines);
        System.out.println("The title of the file is "+document.getTitle());
        System.out.println("The normalised date of the file is "+document.getCreationDate());
        HashMap<String, Integer> stringIntegerHashMap = pd.readNumberWords(document.getText(), " ");

        pd.printMap(stringIntegerHashMap);

        CreateFile cf = new CreateFile();
        cf.fileCreate();
    }
}
