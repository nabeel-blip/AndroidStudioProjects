package com.example.recycleandcardview;

public class Movie {
    private String title;
    private int image;
    public Movie(String title, int image) {
        this.title = title;
        this.image = image == 0 ? R.drawable.images:image;
    }
    public Movie(String title) {
        this.title = title;
        this.image = R.drawable.images;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}