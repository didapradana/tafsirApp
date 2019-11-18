package com.example.tafsir;

import java.util.ArrayList;

public class DataTafsirModel {
    private int id,aya,sura,juz;
    private String text;

    public DataTafsirModel() {
    }

    public DataTafsirModel(int id, int aya, int sura, int juz, String text) {
        this.id = id;
        this.aya = aya;
        this.sura = sura;
        this.juz = juz;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAya() {
        return aya;
    }

    public void setAya(int aya) {
        this.aya = aya;
    }

    public int getSura() {
        return sura;
    }

    public void setSura(int sura) {
        this.sura = sura;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
