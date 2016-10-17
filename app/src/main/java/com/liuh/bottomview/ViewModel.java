package com.liuh.bottomview;

/**
 * Created by Liuhe on 2016/10/17.
 */


public class ViewModel {
    private String name;
    private int ico;
    private int icoSelect;
    private int color;
    private int colorSelect;

    public ViewModel(String name, int ico, int icoSelect) {
        this.name = name;
        this.ico = ico;
        this.icoSelect = icoSelect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public int getIcoSelect() {
        return icoSelect;
    }

    public void setIcoSelect(int icoSelect) {
        this.icoSelect = icoSelect;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColorSelect() {
        return colorSelect;
    }

    public void setColorSelect(int colorSelect) {
        this.colorSelect = colorSelect;
    }
}