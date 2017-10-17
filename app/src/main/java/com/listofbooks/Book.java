package com.listofbooks;

/**
 * Created by markcorrado on 10/15/17.
 */

public class Book {
    public String title;
    public String imageURL;
    public String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return(title + " " + imageURL + " " + author);
    }
}
