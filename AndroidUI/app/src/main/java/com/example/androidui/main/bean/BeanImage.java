package com.example.androidui.main.bean;



import android.graphics.Bitmap;

/** 图像信息类 */
public class BeanImage {

    private Bitmap image;
    private String name;
    private String location;

    public BeanImage(Bitmap image, String name, String location) {
        this.image = image;
        this.name = name;
        this.location = location;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}