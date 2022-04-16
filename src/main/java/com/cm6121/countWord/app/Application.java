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
            ParseDocument pd = new ParseDocument();
            List<String> documentLines = pd.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", name);
            Document document = pd.documentParse(documentLines);
            System.out.println("The file name is " + name+", the title is "+document.getTitle()+", the creation date is "+document.getCreationDate());
        }

        for(int i = 0; i<listFile.length; i++) {
            ParseDocument pd = new ParseDocument();
            List<String> documentLines = pd.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
            Document document = pd.documentParse(documentLines);
            //System.out.println need to be removed later
            System.out.println("The tile of the document is "+document.getTitle());
            System.out.println("The creation date of the document is "+document.getCreationDate());
            HashMap<String, Integer> stringIntegerHashMap = pd.readNumberWords(document.getText(), " ");

            pd.printWords(stringIntegerHashMap);
        }

        CreateFile cf = new CreateFile();
        cf.fileCreate();
    }
}
