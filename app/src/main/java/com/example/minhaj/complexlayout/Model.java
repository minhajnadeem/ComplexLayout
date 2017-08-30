package com.example.minhaj.complexlayout;

/**
 * Created by minhaj on 29/08/2017.
 */

public class Model {

    private int imgRes;
    private String text;

    public Model(int imgRes, String text){
        setImgRes(imgRes);
        setText(text);
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
