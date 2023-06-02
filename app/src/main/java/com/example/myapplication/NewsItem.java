package com.example.myapplication;

import java.util.ArrayList;

public class NewsItem {
    private String imgId;
    private String title;
    private String description;
    ArrayList<NewsItem> newsList;


    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
