package com.example.tafsir.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.tafsir.model.SuratTafsir;
import com.example.tafsir.model.TafsirWajizModel;
import com.example.tafsir.persistence.SuratTafsirDao;
import com.example.tafsir.persistence.TafsirDatabase;
import com.example.tafsir.persistence.TafsirWajizDao;

import java.util.List;

public class TafsirWajizRepository {
    private TafsirWajizDao tafsirWajizDao;

    public TafsirWajizRepository(Context context) {
        TafsirDatabase db = TafsirDatabase.getDatabase(context.getApplicationContext());
        tafsirWajizDao = db.getTafsirWajizDao();
    }

    public LiveData<List<TafsirWajizModel>> getAllWajizTafsir(){
        return tafsirWajizDao.getAllWajizTafsir();
    }
}
