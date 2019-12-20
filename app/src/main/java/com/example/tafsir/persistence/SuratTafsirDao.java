package com.example.tafsir.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.tafsir.model.SuratTafsir;
import com.example.tafsir.model.TafsirWajizModel;

import java.util.List;

@Dao
public interface SuratTafsirDao {
    @Query("SELECT * FROM namasurat")
    LiveData<List<SuratTafsir>> getAllSurat();

    @Query("SELECT * FROM namasurat WHERE id == :id")
    LiveData<SuratTafsir> getSuratById(int id);

    @Query("SELECT * FROM namasurat WHERE posisi == :posisi")
    LiveData<SuratTafsir> getSuratByPosisi(int posisi);
}
