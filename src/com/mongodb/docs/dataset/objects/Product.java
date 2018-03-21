package com.mongodb.docs.dataset.objects;

import java.util.List;

public final class Product {
    private String name;
    private int qty;
    private List<String> tags;
    private Size size;
    private List<Rating> ratings;
    private String status;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(final int qty) {
        this.qty = qty;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    public void setSize(final Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public void setRating(final List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRating() {
        return this.ratings;
    }
}