package com.mongodb.docs.dataset.objects;

import java.util.Date;
import java.util.List;

public final class Product {
    private String item;
    private int qty;
    private List<String> tags;
    private Size size;
    private List<Rating> ratings;
    private String status;
    private Date currentDate;
    
    public Date getCurrentDate() {
        return this.currentDate;
    }
    
    public void setCurrentDate(Date date) {
        this.currentDate = date;
    }

    public Product() {
    }

    public String getItem() {
        return item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setItem(final String name) {
        this.item = name;
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