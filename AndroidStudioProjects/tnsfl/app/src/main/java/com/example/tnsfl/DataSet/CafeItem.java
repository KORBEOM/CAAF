package com.example.tnsfl.DataSet;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.io.BufferedInputStream;
import java.util.List;

public class CafeItem {

    @SerializedName("image")
    private String iamge;



    @SerializedName("Name")
    private String title;

    @SerializedName("Categorie")
    private String categorie;

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Location")
    private String location;

    @SerializedName("Location2")
    private String location2;

    public String  getImage(){return this.iamge; };
    public String getTitle(){return this.title;};
    public String getCategorie(){return this.categorie;};
    public String getPhone(){return this.phone;};
    public String getLocation(){return this.location;};
    public String getLocation2(){return this.location2;};


}
