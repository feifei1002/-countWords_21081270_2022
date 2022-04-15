package com.cm6121.countWord.code;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public void fileCreate() {

        try {
            Document document = new Document();
            File fl = new File("StudentCSVSaved"+"\\"+document.getTitle()+"_allWords"+".csv");
            if (fl.createNewFile()) {
                System.out.println("File " + fl.getName()+ " successfully created");
            } else {
                System.out.println("File already exists");
            }
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
