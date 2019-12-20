package com.example.tafsir.persistence;

import android.content.Context;
import android.content.res.AssetManager;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.tafsir.helper.ApplicationConstants;
import com.example.tafsir.helper.Converters;
import com.example.tafsir.model.TafsirWajizModel;

import java.io.IOException;

@Database(entities = { TafsirWajizModel.class }, exportSchema = false, version = ApplicationConstants.DATABASE_VERSION)
@TypeConverters({Converters.class})
public abstract class TafsirDatabase extends RoomDatabase {

    public abstract TafsirWajizDao getTafsirWajizDao();

    private static TafsirDatabase db;

    public static synchronized TafsirDatabase getDatabase(Context context){
        AssetManager am = context.getAssets();
        try {
            db = Room.databaseBuilder(context.getApplicationContext(),
                    TafsirDatabase.class
                    , am.open("db/tafsir.db")
                            .toString()
            ).fallbackToDestructiveMigration().build();
            return db;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
