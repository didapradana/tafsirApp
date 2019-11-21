package com.example.tafsir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TabMain extends AppCompatActivity {
    DataHelper dbHelper;
    Cursor cursor;
    RecyclerView recyclerViewTafsirTahili, recyclerViewTafsirWajiz;
    LinearLayoutManager linearLayoutManagerTafsirTahili, linearLayoutManagerTafsirWajiz;
    int currentSura = 1;

    ArrayList<DataTafsirModel> dataTafsir = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        dbHelper = new DataHelper(getApplicationContext());

        linearLayoutManagerTafsirTahili = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        );

        linearLayoutManagerTafsirWajiz = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        );

        tabInit();
        tampilTafsirWajiz();
        tampilTafsirTahili();
        getItemPosition();
    }

    private void tabInit(){
        TabHost tabs = findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab_tafsir_tahili);
        spec.setIndicator("TAHILI");
        tabs.addTab(spec);
        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab_tafsir_wajiz);
        spec.setIndicator("WAJIZ");
        tabs.addTab(spec);
    }

    public void tampilTafsirTahili(){
        DataTafsirModel dt;
        TafsirAdapter tafsirAdapter;
        SnapHelper snapHelper = new PagerSnapHelper();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT sura, aya, juz, text FROM ringkas_kemenag", null);
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

            tampilTafsirTahili();
        }

        Log.d("dataTafsir data", dataTafsir.get(0).getText());
        tafsirAdapter = new TafsirAdapter(this, R.layout.text_item, dataTafsir);

        recyclerViewTafsirTahili = findViewById(R.id.rvTafsirTahili);
        recyclerViewTafsirTahili.setLayoutManager(linearLayoutManagerTafsirTahili);
        recyclerViewTafsirTahili.setAdapter(tafsirAdapter);
        snapHelper.attachToRecyclerView(recyclerViewTafsirTahili);
    }

    public void tampilTafsirWajiz(){
        DataTafsirModel dt;
        TafsirAdapter tafsirAdapter;
        SnapHelper snapHelper = new PagerSnapHelper();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT sura, aya, juz, text FROM ringkas_kemenag", null);
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

            tampilTafsirWajiz();
        }

        Log.d("dataTafsir data", dataTafsir.get(0).getText());
        tafsirAdapter = new TafsirAdapter(this, R.layout.text_item, dataTafsir);

        recyclerViewTafsirWajiz = findViewById(R.id.rvTafsirWajiz);
        recyclerViewTafsirWajiz.setLayoutManager(linearLayoutManagerTafsirWajiz);
        recyclerViewTafsirWajiz.setAdapter(tafsirAdapter);
        snapHelper.attachToRecyclerView(recyclerViewTafsirWajiz);
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

    private void getItemPosition(){
        recyclerViewTafsirTahili.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int position;
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    onSuraChanged(dataTafsir.get(position).getSura());
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                position = linearLayoutManagerTafsirTahili.findFirstVisibleItemPosition();
            }
        });
        recyclerViewTafsirWajiz.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int position;
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    onSuraChanged(dataTafsir.get(position).getSura());
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                position = linearLayoutManagerTafsirWajiz.findFirstVisibleItemPosition();
            }
        });
    }

    private void onSuraChanged(int numberSura){
        if (this.currentSura != numberSura) {
            Toast.makeText(this, "Anda di sura " + numberSura, Toast.LENGTH_SHORT).show();
            this.currentSura = numberSura;
        }
    }
}
