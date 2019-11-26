package com.example.tafsir;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_kontak.db";
    private static final int DATABASE_VERSION = 1;


    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE trans (\n" +
                "  id INTEGER PRIMARY KEY NOT NULL,\n" +
                "  trans_key VARCHAR,\n" +
                "  trans_name VARCHAR,\n" +
                "  trans_desc VARCHAR,\n" +
                "  trans_order INTEGER,\n" +
                "  trans_dir VARCHAR,\n" +
                "  fontname VARCHAR DEFAULT ('Árial'),\n" +
                "  typenya INTEGER DEFAULT (0),\n" +
                "  display INTEGER DEFAULT (1),\n" +
                "  download STRING\n" +
                ");";
        Log.d("Creating SQLite db", "onCreate" + sql);
        sqLiteDatabase.execSQL(sql);

        String sql2 = "CREATE TABLE ringkas_kemenag (\n" +
                "  id INT (4) PRIMARY KEY NOT NULL,\n" +
                "  sura INT (3) NOT NULL DEFAULT '0',\n" +
                "  aya INT (3) NOT NULL DEFAULT '0',\n" +
                "  juz INT (3) NOT NULL DEFAULT '0',\n" +
                "  text TEXT NOT NULL\n" +
                ");";
        Log.d("Creating SQLite db", "onCreate" + sql2);
        sqLiteDatabase.execSQL(sql2);

        String sql3 = "CREATE TABLE tahlili (\n" +
                "  id INT (4) PRIMARY KEY NOT NULL,\n" +
                "  sura INT (3) NOT NULL DEFAULT '0',\n" +
                "  aya INT (3) NOT NULL DEFAULT '0',\n" +
                "  juz INT (3) NOT NULL DEFAULT '0',\n" +
                "  text TEXT NOT NULL\n" +
                ");";
        Log.d("Creating SQLite db", "onCreate" + sql3);
        sqLiteDatabase.execSQL(sql3);

        String sql4 = "CREATE TABLE namasurat (\n" +
                "  id INT,\n" +
                "  namalatin TEXT,\n" +
                "  jumlahayat INT,\n" +
                "  namaarab TEXT,\n" +
                "  kategory TEXT,\n" +
                "  terjemah TEXT,\n" +
                "  posisi INT\n" +
                ");";
        Log.d("Creating SQLite db", "onCreate" + sql4);
        sqLiteDatabase.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}

