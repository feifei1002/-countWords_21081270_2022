package com.cm6121.countWord.code;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    public File folderCreate(String folderName){
        File file1 = new File(folderName);
        return file1;
    }

    public String fileCreate(String fileName) {

        try {
            File fl = new File(fileName);
            if (fl.createNewFile()) {
                System.out.println("File " + fl.getName()+ " successfully created");
            } else {
                System.out.println("File already exists");
            }
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return fileName;
    }
}
