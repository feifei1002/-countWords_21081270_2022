package com.cm6121.countWord.code;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    protected void fileCreate() {

        try {
            Document document = new Document();
            File fl = new File("StudentCSVSaved"+"/"+document.getTitle()+".csv");
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

    public static void main(String[] args) {
        CreateFile cf = new CreateFile();
        cf.fileCreate();
    }
}
