package com.example.tafsir.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.tafsir.model.TafsirWajizModel;

import java.util.List;

@Dao
public interface TafsirWajizDao {
    @Query("SELECT * FROM wajiz")
    LiveData<List<TafsirWajizModel>> getAllWajizTafsir();
}
