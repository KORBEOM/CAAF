package com.example.tnsfl.DataSet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class kakaResult{

        @SerializedName("documents")
        @Expose
        public List<Documents> documents = null;
        public List<Documents> getDocuments(){return documents;};

        public class Documents{

                        @SerializedName("place_name")
                        @Expose
                        String place_name;

                        @SerializedName("distance")
                        @Expose
                        String distance;

                        @SerializedName("place_url")
                        @Expose
                        String place_url;

                        @SerializedName("category_name")
                        @Expose
                        String category_name;

                        @SerializedName("address_name")
                        @Expose
                        String address_name;

                        @SerializedName("road_address_name")
                        @Expose
                        String road_address_name;

                        @SerializedName("id")
                        @Expose
                        String id;

                        @SerializedName("phone")
                        @Expose
                        String phone;

                        @SerializedName("category_group_code")
                        @Expose
                        String category_group_code;

                        @SerializedName("category_group_name")
                        @Expose
                        String category_group_name;

                        @SerializedName("x")
                        @Expose
                        String x;

                        @SerializedName("y")
                        @Expose
                        String y;

                        public String getPlace_name(){return place_name;};
                        public String getDistance(){return distance;};
                        public String getPlace_url(){return place_url;};
                        public String getCategory_name(){return category_name;};
                        public String getAddress_name(){return address_name;};
                        public String getRoad_address_name(){return road_address_name;};
                        public String getId(){return id;};
                        public String getPhone(){return phone;};
                        public String getCategory_group_code(){return category_group_code;};
                        public String getCategory_group_name(){return category_group_name;};
                        public String getX(){return x;};
                        public String getY(){return y;};


        }

}



