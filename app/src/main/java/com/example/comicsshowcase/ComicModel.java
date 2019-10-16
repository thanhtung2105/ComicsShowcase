package com.example.comicsshowcase;

public class ComicModel {
    public static final String COMIC = "comic";
    public static final String NAME = "name";
    public static final String IMG_SRC = "img_src";
    public static final String CONTENT = "content";

    private String comic_img;
    private String comic_name;
    private String comic_introduction;

    public ComicModel(String comic_img, String comic_name, String comic_introduction) {
        this.comic_img = comic_img;
        this.comic_name = comic_name;
        this.comic_introduction = comic_introduction;
    }

    public String getComic_img() {
        return comic_img;
    }

    public void setComic_img(String comic_img) {
        this.comic_img = comic_img;
    }

    public String getComic_name() {
        return comic_name;
    }

    public void setComic_name(String comic_name) {
        this.comic_name = comic_name;
    }

    public String getComic_introduction() { return comic_introduction; }

    public void setComic_introduction(String comic_introduction) { this.comic_introduction = comic_introduction; }
}

