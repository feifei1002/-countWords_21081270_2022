package com.cm6121.countWord.app;


import com.cm6121.countWord.code.*;

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
        System.out.println("Welcome to Count Word Application!");
        System.out.println();

        CreateFile cf = new CreateFile();
        File file1 = cf.folderCreate(System.getProperty("user.home") + "\\StudentCSVSaved");
        cf.fileCreate(file1+"\\"+"CSVAllDocuments_allWords.csv");
        System.out.println();

        for (int i = 0; i < listFile.length; i++) {
            List<String> documentLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
            Document document = parse.documentParse(documentLines);
            cf.fileCreate(file1 + "\\" + (document.getTitle().replaceAll(" ", "_") + "_allWords.csv"));
            System.out.println();
        }
        System.out.println();

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
        }else if(!answer1.equals("N")){
            System.out.println("Sorry, invalid input");
            System.exit(0);
        }
        System.out.println();

        System.out.println("Do you want to display the number of occurrences of the words for each document? (Y/N)");
        String answer2 = sc.nextLine();
        if(answer2.equals("Y")) {
            for (int i = 0; i < listFile.length; i++) {
                List<String> documentLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
                Document document = parse.documentParse(documentLines);
                System.out.println();
                System.out.println("The tile of the document is " + document.getTitle());
                System.out.println("The creation date of the document is " + document.getCreationDate());
                System.out.println("Here are the occurrences of words in the document " + document.getTitle());
                System.out.println();
                HashMap<String, Integer> wordsOccurrencesMap = parse.readNumberWords(document.getText(), " ");

                Map<String, Integer> ascendingOrder = parse.printWordsOccurrences(wordsOccurrencesMap);
                Path path = Paths.get(System.getProperty("user.home"), "StudentCSVSaved", (document.getTitle().replaceAll(" ", "_") + "_allWords.csv"));
                File fileWrite = new File(path.toString());
                WriteDocument.documentWrite(document, ascendingOrder, fileWrite);
            }
        }else if(!answer2.equals("N")){
            System.out.println("Sorry, invalid input");
            System.exit(0);
        }


        String corpusText = null;
        String corpusTextFinalList[];
        for (int i = 0; i< listFile.length; i++) {
            List<String> documentLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
            for (String text : documentLines) {
                String corpusTextBeforeList[];
                corpusTextBeforeList = text.split(",");
                corpusTextBeforeList[0] = " ".trim();
                corpusTextBeforeList[corpusTextBeforeList.length - 1] = " ".trim();
                corpusTextFinalList = corpusTextBeforeList;
                for (int j = 0; j < corpusTextFinalList.length; j++) {
                    corpusText = corpusText + corpusTextFinalList[j];
                }
            }
        }

        System.out.println("Do you want to enter a word and display the number of occurrences of it in each document? (Y/N)");
        String answer3 = sc.nextLine();
        if(answer3.equals("Y")) {
            System.out.println("What is the word you would like to search?");
            String wordSearch = sc.nextLine();
            int total = 0;
            for (int i = 0; i < listFile.length; i++) {
                List<String> documentLines = parse.readFile("Desktop", "ASE Year 1", "Java Assessment 2", "cm6121_assessment_2_start", "build", "resources", "main", "FolderDocumentsToRead", listFile[i]);
                Document document = parse.documentParse(documentLines);
                HashMap<String, Integer> wordsOccurrencesMap = parse.readNumberWords(document.getText(), " ");
                if (wordsOccurrencesMap.containsKey(wordSearch)) {
                    System.out.println("The number of times the word '" + wordSearch + "' appears in the document " + document.getTitle() + " is " + wordsOccurrencesMap.get(wordSearch));
                    total = total + wordsOccurrencesMap.get(wordSearch);

                }else if(!wordsOccurrencesMap.containsKey(wordSearch)){
                    System.out.println("Sorry the word '"+ wordSearch + "' is not in the document " + document.getTitle());
                }
            }
            System.out.println("The number of times the word '" + wordSearch + "' appears in the whole corpus is " +total);
        }else if(!answer3.equals("N")){
            System.out.println("Sorry, invalid input");
            System.exit(0);
        }
        System.out.println();

        System.out.println("Do you want to display the number of occurrences of the 20 words that have the most occurrences in the whole corpus? (Y/N)");
        String answer4 = sc.nextLine();
        if(answer4.equals("Y")) {
            HashMap<String, Integer> wordsOccurrencesMap = parse.readNumberWords(corpusText, " ");
            Map<String, Integer> descendingOrder = parse.printAllWordsOccurrences(wordsOccurrencesMap);
            System.out.println("Here are the 20 words that have the most occurrences in the whole corpus:");
            parse.printFirst20Words(descendingOrder);
            Path pathAll = Paths.get(System.getProperty("user.home"), "StudentCSVSaved", "CSVAllDocuments_allWords.csv");
            File fileWriteAll = new File(pathAll.toString());
            WriteDocument.documentWriteAll(corpusText, descendingOrder, fileWriteAll);
        }else if(!answer4.equals("N")){
            System.out.println("Sorry, invalid input");
            System.exit(0);
        }
        System.out.println();
        System.out.println("Thank you for using Count Word Application!");
        System.exit(0);
    }
}
