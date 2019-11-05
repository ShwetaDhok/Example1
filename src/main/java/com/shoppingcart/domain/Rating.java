package com.shoppingcart.domain;

public class Rating {
    public String getId() {
        return id;
    }

    public Rating(String id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public Rating() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String id;
    public int rating;
}
