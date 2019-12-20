package com.example.tafsir.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "namasurat")
public class SuratTafsir {
    @PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "namalatin")
    private String namaLatin;

    @ColumnInfo(name = "namaarab")
    private String namaArab;

    @ColumnInfo(name = "jumlahayat")
    private int jumlahAyat;

    @ColumnInfo(name = "terjemahan")
    private String terjemahan;

    @ColumnInfo(name = "posisi")
    private String posisi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLatin() {
        return namaLatin;
    }

    public void setNamaLatin(String namaLatin) {
        this.namaLatin = namaLatin;
    }

    public String getNamaArab() {
        return namaArab;
    }

    public void setNamaArab(String namaArab) {
        this.namaArab = namaArab;
    }

    public int getJumlahAyat() {
        return jumlahAyat;
    }

    public void setJumlahAyat(int jumlahAyat) {
        this.jumlahAyat = jumlahAyat;
    }

    public String getTerjemahan() {
        return terjemahan;
    }

    public void setTerjemahan(String terjemahan) {
        this.terjemahan = terjemahan;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
}
