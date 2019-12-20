package com.example.tafsir.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tafsir.helper.ApplicationConstants;
import com.example.tafsir.helper.Converters;
import com.example.tafsir.model.TafsirWajizModel;

@Database(entities = { TafsirWajizModel.class }, exportSchema = false, version = ApplicationConstants.DATABASE_VERSION)
@TypeConverters({Converters.class})
public abstract class TafsirDatabase extends RoomDatabase {

    public abstract TafsirWajizDao getTafsirWajizDao();

    private static volatile TafsirDatabase db;

    public static TafsirDatabase getDatabase(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(),
                TafsirDatabase.class, "tafsir").fallbackToDestructiveMigration().build();
        return db;
    }
}
