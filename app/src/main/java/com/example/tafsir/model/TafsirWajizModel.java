package com.example.tafsir.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wajiz")
public class TafsirWajizModel {
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "aya")
    private int aya;

    @ColumnInfo(name = "juz")
    private int juz;

    @ColumnInfo(name = "sura")
    private String sura;

    @ColumnInfo(name = "text")
    private String text;

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

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }

    public String getSura() {
        return sura;
    }

    public void setSura(String sura) {
        this.sura = sura;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
