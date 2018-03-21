package com.mongodb.docs.dataset.objects;

public class Size {

    private double height;
    private double width;
    private double length;
    private String unit;
    private String sizeoverride;

    public void setHeight(final double height) {
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWidth(final double width) {
        this.width = width;
    }

    public double getWidth() {
        return this.width;
    }

    public void setLength(final double length) {
        this.length = length;
    }

    public double getLength() {
        return this.length;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setSizeOverride(String override) {
        this.sizeoverride = override;
    }

    public String getSizeOverride() {
        return this.sizeoverride;
    }

}
