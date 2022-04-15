package com.cm6121.countWord.code;

public class Document {

    private String title;
    private String text;
    private String creationDate;

    protected void setTitle(String title){
        this.title = title;
    }

    protected void setText(String text){
        this.text = text;
    }

    protected void setCreationDate(String creationDate){
        this.creationDate = creationDate;
    }

    public String getTitle(){
        return title;
    }

    public String getText(){
        return text;
    }

    public String getCreationDate(){
        return creationDate;
    }
}
