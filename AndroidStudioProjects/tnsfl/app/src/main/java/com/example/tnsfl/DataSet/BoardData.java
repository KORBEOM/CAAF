package com.example.tnsfl.DataSet;

import com.google.gson.annotations.SerializedName;

public class BoardData {
    @SerializedName("number")
    private int number;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("id")
    private String userid;

    @SerializedName("date")
    private String date;

    @SerializedName("hit")
    private int hit;

    @SerializedName("comment")
    private String comment;

    @Override
    public  String toString(){
        return "BoardData{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", content='" + content +'\'' +
                ", id='" + userid +'\'' +
                ", date='" + date +'\'' +
                ", comment=" + comment +'\''+
                ", hit=" + hit + '}';

    }
}
