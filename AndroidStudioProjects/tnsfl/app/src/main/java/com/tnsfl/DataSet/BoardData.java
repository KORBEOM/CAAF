package com.tnsfl.DataSet;

import com.google.gson.annotations.SerializedName;

public class BoardData {
    @SerializedName("number")
    private int number;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String Contents;

    @SerializedName("id")
    private String NickName;

    @SerializedName("date")
    private String Date;

    @SerializedName("hit")
    private String hit;

    @SerializedName("comment")
    private String comment;

    @Override
    public  String toString(){
        return "BoardData{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", content='" + Contents +'\'' +
                ", Nickname='" + NickName +'\'' +
                ", Date='" + Date +'\'' +
                ", comment=" + comment +'\''+
                ", hit=" + hit + '}';

    }

    public int getNumber(){
        return this.number;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContents(){
        return this.Contents;
    }
    public String getNickName(){
        return this.NickName;
    }
    public String getDate(){
        return this.Date;
    }
    public String getHit(){
        return this.hit;
    }
    public String getComment() {
        return  this.comment;
    }
}
