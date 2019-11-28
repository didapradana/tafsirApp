package com.example.tafsir.model;

public class Surat {
    private int id;
    private String namalatin;
    private int jumlahayat;
    private String namaarab;
    private String kategory;
    private String terjemah;
    private int posisi;

    public Surat(){ }

    public Surat(int id, String namalatin, int jumlahayat, String namaarab, String kategory, String terjemah, int posisi) {
        this.id = id;
        this.namalatin = namalatin;
        this.jumlahayat = jumlahayat;
        this.namaarab = namaarab;
        this.kategory = kategory;
        this.terjemah = terjemah;
        this.posisi = posisi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamalatin() {
        return namalatin;
    }

    public void setNamalatin(String namalatin) {
        this.namalatin = namalatin;
    }

    public int getJumlahayat() {
        return jumlahayat;
    }

    public void setJumlahayat(int jumlahayat) {
        this.jumlahayat = jumlahayat;
    }

    public String getNamaarab() {
        return namaarab;
    }

    public void setNamaarab(String namaarab) {
        this.namaarab = namaarab;
    }

    public String getKategory() {
        return kategory;
    }

    public void setKategory(String kategory) {
        this.kategory = kategory;
    }

    public String getTerjemah() {
        return terjemah;
    }

    public void setTerjemah(String terjemah) {
        this.terjemah = terjemah;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }
}
