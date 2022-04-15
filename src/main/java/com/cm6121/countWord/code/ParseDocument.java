package com.cm6121.countWord.code;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ParseDocument {

    public List<String> readFile(String... pathDocument) throws IOException {
        StringBuffer sb = new StringBuffer();
        for(String s:pathDocument){
            sb.append(s);
            sb.append("/");
        }

        Path path = Paths.get(System.getProperty("user.home"), sb.toString());
        List<String> strings = Files.readAllLines(path);
        return strings;
    }

    public Document documentParse(List<String> allLines){
        Document document = null;
        String line = allLines.get(1);
        String[] split = line.split("\"");
        Document doc = new Document();
        doc.setTitle(split[0].substring(0,split[0].length()-1).trim());
        doc.setCreationDate(split[2].substring(1).trim());
        doc.setText(split[1]);
        System.out.println(doc.getTitle());
        System.out.println(doc.getText());
        System.out.println(doc.getCreationDate());

//        if(allLines.size() > 0) {
//            for (String s : allLines) {
//                document = new Document();
//                String[] split = s.split(parser);
//
//                for (String y : split) {
//                    String[] split1 = y.split(parser);
//                    System.out.println(split1[0]+".......hello");
//                    String[] split2 = split1[0].split(",");
//                    System.out.println(split2[0]+".......bye");
//                    if (split[0].equals("title")) {
//                        System.out.println(split1[0].trim()+"ooooo");
//                        document.setTitle(split1[0].trim());
//                    } else if (split1[0].equals("text")) {
//                        System.out.println(split1[1]);
//                        document.setText(split1[1].trim());
//                    } else if (split1[0].equals("normalized_date")) {
//                        System.out.println(split1[1]);
//                        document.setCreationDate(split1[1].trim());
//                    }
//                }
//            }
//        }
        return document;
    }
}
