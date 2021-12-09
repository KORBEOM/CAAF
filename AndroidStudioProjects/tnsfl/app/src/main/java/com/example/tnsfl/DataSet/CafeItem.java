package com.example.tnsfl.DataSet;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class CafeItem {

    @SerializedName("image")
    private Bitmap iamge;

    @SerializedName("Name")
    private String title;

    @SerializedName("Categorie")
    private String categorie;

    @SerializedName("Phone")
    private String phone;

    public Bitmap getImage(){return this.iamge; };
    public String getTitle(){return this.title;};
    public String getCategorie(){return this.categorie;};
    public String getPhone(){return this.phone;};


}
