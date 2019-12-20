package com.example.tafsir.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tafsir.helper.ApplicationConstants;
import com.example.tafsir.helper.Converters;
import com.example.tafsir.model.SuratTafsir;

@Database(entities = { SuratTafsir.class }, exportSchema = false, version = ApplicationConstants.DATABASE_VERSION)
@TypeConverters({Converters.class})
public abstract class SuratTafsirDatabase extends RoomDatabase {

    public abstract SuratTafsirDao getSuratDao();

    private static SuratTafsirDatabase db;

    public static SuratTafsirDatabase getDatabase(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(),
                SuratTafsirDatabase.class, "tafsir").fallbackToDestructiveMigration().build();
        return db;
    }
}
