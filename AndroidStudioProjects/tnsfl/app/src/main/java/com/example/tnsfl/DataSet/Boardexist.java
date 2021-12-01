package com.example.tnsfl.DataSet;

import com.google.gson.annotations.SerializedName;

public class Boardexist {

    @SerializedName("board_number")
    private int board_number;

    @SerializedName("id")
    private String userid;

    @SerializedName("date")
    private String date;

    @SerializedName("content")
    private String content;


    @Override
    public  String toString() {
        return  "  Boardexist{" +
                "  board_number='" + board_number +'\'' +
                ", id='" + userid +'\'' +
                ", date='" + date +'\'' +
                ", content=" + content + '}';

    }
}