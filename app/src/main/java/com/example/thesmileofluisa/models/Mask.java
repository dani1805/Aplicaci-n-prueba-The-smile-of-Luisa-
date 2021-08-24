package com.example.thesmileofluisa.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Mask implements Parcelable {

    private String name, model;
    private double price;
    private int img;

    public Mask(String name, String model, double price, int img) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.img = img;
    }

    public Mask() {

    }


    protected Mask(Parcel in) {
        name = in.readString();
        model = in.readString();
        price = in.readDouble();
        img = in.readInt();
    }

    public static final Creator<Mask> CREATOR = new Creator<Mask>() {
        @Override
        public Mask createFromParcel(Parcel in) {
            return new Mask(in);
        }

        @Override
        public Mask[] newArray(int size) {
            return new Mask[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(model);
        dest.writeDouble(price);
        dest.writeInt(img);
    }
}
