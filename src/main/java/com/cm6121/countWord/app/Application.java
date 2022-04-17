package com.cm6121.countWord.app;


import com.cm6121.countWord.code.CreateFile;
import com.cm6121.countWord.code.Document;
import com.cm6121.countWord.code.ParseDocument;
import com.cm6121.countWord.code.WriteDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        String documentToRead = ClassLoader.getSystemClassLoader().getResource("FolderDocumentsToRead").getPath();
        System.out.println("The counting words application");
        System.out.println(documentToRead);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        File file = new File(System.getProperty("user.home")  + "\\Desktop\\ASE Year 1\\Java Assessment 2\\cm6121_assessment_2_start\\build\\resources\\main\\FolderDocumentsToRead");
        String[] listFile = file.list();
        ParseDocument parse = new ParseDocument();

        System.out.println("Do you want to display the names and the number of documents? (Y/N)");
        String answer1 = sc.nextLine();
        if(answer1.equals("Y")) {
            System.out.println("The number of documents in the folder is " + listFile.length);
            System.out.println();

            for (String name : listFile) {
                List<String> textLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", name);
                Document document = parse.documentParse(textLines);
                System.out.println("The file name is " + name + ", the title is " + document.getTitle() + ", the creation date is " + document.getCreationDate());
            }
        }
        System.out.println();

        CreateFile cf = new CreateFile();
        File file1 = cf.folderCreate(System.getProperty("user.home") + "\\StudentCSVSaved");
        cf.fileCreate(file1+"\\"+"CSVAllDocuments_allWords.csv");
        System.out.println();

        System.out.println("Do you want to display the number of occurrences of the words for each document? (Y/N)");
        String answer2 = sc.nextLine();
        if(answer2.equals("Y")) {
            for (int i = 0; i < listFile.length; i++) {
                List<String> documentLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
                Document document = parse.documentParse(documentLines);
                cf.fileCreate(file1 + "\\" + (document.getTitle() + "_allWords.csv"));
                //System.out.println need to be removed later
                System.out.println();
                System.out.println("The tile of the document is " + document.getTitle());
                System.out.println("The creation date of the document is " + document.getCreationDate());
                HashMap<String, Integer> wordsOccurrencesMap = parse.readNumberWords(document.getText(), " ");

                Map<String,Integer> ascendingOrder = parse.printWordsOccurrences(wordsOccurrencesMap);
                Path path = Paths.get(System.getProperty("user.home"), "StudentCSVSaved", (document.getTitle() + "_allWords.csv"));
                File fileWrite = new File(path.toString());
                WriteDocument.documentWrite(document, ascendingOrder, fileWrite);

                HashMap<String,Integer> allWordsOccurrencesMap = parse.readCorpus(ascendingOrder);
                Map<String, Integer> descendingOrder = parse.printAllWordsOccurrences(allWordsOccurrencesMap);
                Path pathAll = Paths.get(System.getProperty("user.home"), "StudentCSVSaved", "CSVAllDocuments_allWords.csv");
                File fileWriteAll = new File(pathAll.toString());
                WriteDocument.documentWrite(document, descendingOrder, fileWriteAll);
            }
        }

    }
}
