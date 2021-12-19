package com.tnsfl.DataSet;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class marketData {

    public marketData(Bitmap image , String text1,String text2,String text3){
        this.image = image;
        this.tag1 = text1;
        this.tag2 = text2;
        this.tag3 = text3;
    }
    @SerializedName("image")
    private Bitmap image;

    @SerializedName("tag_one")
    private String tag1;

    @SerializedName("tag_two")
    private String tag2;

    @SerializedName("tag_three")
    private String tag3;

    public Bitmap getImage(){return image;}
    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag1(String text1){
        this.tag1 = text1;
    }
    public void setTag2(String text2){
        this.tag2 = text2;
    }
    public void setTag3(String text3){
        this.tag3 = text3;
    }
}
