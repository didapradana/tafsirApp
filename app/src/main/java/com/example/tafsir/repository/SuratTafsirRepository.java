package com.example.tafsir.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.tafsir.model.SuratTafsir;
import com.example.tafsir.model.TafsirWajizModel;
import com.example.tafsir.persistence.SuratTafsirDao;
import com.example.tafsir.persistence.SuratTafsirDatabase;
import com.example.tafsir.persistence.TafsirDatabase;
import com.example.tafsir.persistence.TafsirWajizDao;

import java.util.List;

public class SuratTafsirRepository {
    private SuratTafsirDao suratTafsirDao;

    public SuratTafsirRepository(Context context) {
        SuratTafsirDatabase db = SuratTafsirDatabase.getDatabase(context.getApplicationContext());
        suratTafsirDao = db.getSuratDao();
    }

    public LiveData<List<SuratTafsir>> getAllSurat(){
        return suratTafsirDao.getAllSurat();
    }

    public LiveData<SuratTafsir> getSuratByPosition(int position){
        return suratTafsirDao.getSuratByPosisi(position);
    }

    public LiveData<SuratTafsir> getSuratById(int id){
        return suratTafsirDao.getSuratById(id);
    }
}
