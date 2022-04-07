package com.cm6121.countWord.code;

public class Document {

    private String title;
    private String text;
    private String creationMonth;
    private int creationYear;

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setText(String text){
        this.text = text;
    }

    protected void setCreationMonth(String creationMonth){
        this.creationMonth = creationMonth;
    }

    protected void setCreationYear(int creationYear){
        this.creationYear = creationYear;
    }

    protected String getTitle(){
        return title;
    }

    protected String getText(){
        return text;
    }

    protected String getCreationMonth(){
        return creationMonth;
    }

    protected int getCreationYear(){
        return creationYear;
    }
}
