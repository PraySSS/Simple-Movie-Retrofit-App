package com.example.movieapplication;

import com.google.gson.annotations.SerializedName;

public class MovieModel {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String name;
    @SerializedName("rating")
    float rating;
    @SerializedName("poster")
    String image;

//    Nested object
    @SerializedName("details")
    private MoreDetails moreDetails;

    public MovieModel(String id, String name, float rating, String image, MoreDetails moreDetails) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.moreDetails = moreDetails;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getImage() {
        return image;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }
}
