package com.mongodb.docs.dataset.objects;

public class Size {

    private double h;
    private double w;
    private double l;
    private String uom;
    private String sizeoverride;

    public void setH(final double height) {
        this.h = height;
    }

    public double getH() {
        return this.h;
    }

    public void setW(final double width) {
        this.w = width;
    }

    public double getW() {
        return this.w;
    }

    public void setL(final double length) {
        this.l = length;
    }

    public double getL() {
        return this.l;
    }

    public void setUom(final String unit) {
        this.uom = unit;
    }

    public String getUom() {
        return this.uom;
    }

    public void setSizeOverride(String override) {
        this.sizeoverride = override;
    }

    public String getSizeOverride() {
        return this.sizeoverride;
    }

}
