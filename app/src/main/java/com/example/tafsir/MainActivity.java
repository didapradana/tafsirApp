package com.example.tafsir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataHelper dbHelper;
    Cursor cursor, cursor2;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DataHelper(getApplicationContext());

        tampil();
    }
    public void tampil(){
        ArrayList<DataTafsirModel> dataTafsir = new ArrayList<>();
        DataTafsirModel dt,dt2;
        TafsirAdapter tafsirAdapter;
        SnapHelper snapHelper = new PagerSnapHelper();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT sura, aya, juz, text FROM ringkas_kemenag", null);
        cursor2 = db.rawQuery("SELECT text FROM tahlili GROUP BY juz", null);
        Log.d("info", "Masook sini!");
        Log.d("info Cursor", String.valueOf(cursor.getCount()));
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                dt = new DataTafsirModel();
                dt.setSura(cursor.getInt(0));
                dt.setAya(cursor.getInt(1));
                dt.setJuz(cursor.getInt(2));
                dt.setText(cursor.getString(3));
                dataTafsir.add(dt);
            }

        } else {
            insertFromFile(this, R.raw.trans);
            int count = insertFromFile(this, R.raw.ringkas_kemenag);
            int count2 = insertFromFile(this, R.raw.tahlili);

            Log.d("Inserted Data", String.valueOf(count));
            Log.d("Inserted Data", String.valueOf(count2));

            tampil();
        }

        Log.d("dataTafsir data", dataTafsir.get(0).getText());
        tafsirAdapter = new TafsirAdapter(this, R.layout.text_item, dataTafsir);

        recyclerView = findViewById(R.id.rvTafsir);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false)
        );
        recyclerView.setAdapter(tafsirAdapter);
        snapHelper.attachToRecyclerView(recyclerView);
    }

    public int insertFromFile(Context context, int ResourceId) {
        // Reseting Counter
        int result = 0;

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(ResourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        try {
            while (insertReader.ready()) {
                String insertStmt = insertReader.readLine();
                db.execSQL(insertStmt);
                result++;
            }
            insertReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // returning number of inserted rows
        return result;
    }
}

