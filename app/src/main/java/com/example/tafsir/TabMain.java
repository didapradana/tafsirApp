package com.example.tafsir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tafsir.adapter.NewTafsirAdapter;
import com.example.tafsir.model.Surat;
import com.example.tafsir.model.SuratTafsir;
import com.example.tafsir.model.TafsirWajizModel;
import com.example.tafsir.repository.SuratTafsirRepository;
import com.example.tafsir.repository.TafsirWajizRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabMain extends AppCompatActivity {

    DataHelper dbHelper;
    Cursor cursor;
    RecyclerView recyclerViewTafsirTahili, recyclerViewTafsirWajiz;
    LinearLayoutManager linearLayoutManagerTafsirTahili, linearLayoutManagerTafsirWajiz;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    String currentSura = "";
    TextView tvSuraTitle;
    Button search_btn;
    Spinner spinSurat, spinAyat;

    ArrayList<TafsirWajizModel> dataTafsirWajiz = new ArrayList<>();
    ArrayList<Surat> listDataSurat = new ArrayList<>();
    List<SuratTafsir> listSuratTafsir = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        tvSuraTitle = findViewById(R.id.tvSuraTitle);
        spinAyat = findViewById(R.id.spAyat);

        dbHelper = new DataHelper(getApplicationContext());
        importDataToDatabase();

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
        toolbarInit();
        dataTafsirInit();
        tampilTafsirWajiz();
        tampilTafsirTahili();
        getSuratData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_menu_button:
                search();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dataTafsirInit(){
        TafsirWajizRepository tafsirWajizRepository = new TafsirWajizRepository(this.getApplication());
        tafsirWajizRepository.getAllWajizTafsir().observe(this, tafsirs -> {
            getItemPosition(tafsirs);
            jumpTo(tafsirs);
        });
    }

    private void toolbarInit(){
        Toolbar customToolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(customToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
        SnapHelper snapHelper = new PagerSnapHelper();
        List<TafsirWajizModel> dataWajiz = new ArrayList<>();
        TafsirWajizRepository tafsirWajizRepository = new TafsirWajizRepository(this.getApplication());
        tafsirWajizRepository.getAllWajizTafsir().observe(this, tafsirWajiz -> {
            NewTafsirAdapter newTafsirAdapter = new NewTafsirAdapter(this, R.layout.text_item, tafsirWajiz);

            recyclerViewTafsirTahili = findViewById(R.id.rvTafsirTahili);
            recyclerViewTafsirTahili.setLayoutManager(linearLayoutManagerTafsirTahili);
            recyclerViewTafsirTahili.setAdapter(newTafsirAdapter);
            snapHelper.attachToRecyclerView(recyclerViewTafsirTahili);
        });

    }


    public void tampilTafsirWajiz(){
        SnapHelper snapHelper = new PagerSnapHelper();
        List<TafsirWajizModel> dataWajiz = new ArrayList<>();
        TafsirWajizRepository tafsirWajizRepository = new TafsirWajizRepository(this.getApplication());
        tafsirWajizRepository.getAllWajizTafsir().observe(this, tafsirWajiz -> {
            NewTafsirAdapter newTafsirAdapter = new NewTafsirAdapter(this, R.layout.text_item, tafsirWajiz);

            recyclerViewTafsirWajiz = findViewById(R.id.rvTafsirWajiz);
            recyclerViewTafsirWajiz.setLayoutManager(linearLayoutManagerTafsirWajiz);
            recyclerViewTafsirWajiz.setAdapter(newTafsirAdapter);
            snapHelper.attachToRecyclerView(recyclerViewTafsirWajiz);
        });
    }

    private int insertFromFile(Context context, int ResourceId) {
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

    private void getItemPosition(List<TafsirWajizModel> dataTafsirWajiz){
        recyclerViewTafsirTahili.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int position;
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    onSuraChanged(dataTafsirWajiz.get(position).getSura());
                    recyclerViewTafsirWajiz.scrollToPosition(position);
                    setSessionPage(position);
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
                    onSuraChanged(dataTafsirWajiz.get(position).getSura());
                    recyclerViewTafsirTahili.scrollToPosition(position);
                    setSessionPage(position);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                position = linearLayoutManagerTafsirWajiz.findFirstVisibleItemPosition();
            }
        });
    }

    private void onSuraChanged(String suraTitle){
        if (this.currentSura != suraTitle) {
            tvSuraTitle.setText(suraTitle);
            this.currentSura = suraTitle;
        }
    }

    private void getSuratData(){
        SuratTafsirRepository suratTafsirRepository = new SuratTafsirRepository(this.getApplication());
        suratTafsirRepository.getAllSurat().observe(this, surats -> {
            listSuratTafsir.addAll(surats);
        });
    }

    public List<String> getAllSurats(){
        List<String> listSurat = new ArrayList<String>();

        String selectQuery = "SELECT * FROM namasurat";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Perulangan sejumlah data yang ada dan tambahkan ke list.
        if (cursor.moveToFirst()) {
            do {
                listSurat.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return listSurat;
    }

    private void loadSurat(View v) {
        List<SuratTafsir> suratTafsirs = new ArrayList<>();
        SuratTafsirRepository suratTafsirRepository = new SuratTafsirRepository(this.getApplication());
        suratTafsirRepository.getAllSurat().observe(this, surats -> {
            suratTafsirs.addAll(surats);
        });
        List<String> surats = new ArrayList<>();

        for (SuratTafsir st : suratTafsirs){
            surats.add(st.getNamaLatin());
        }

        spinSurat = v.findViewById(R.id.spSurat);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, surats);

        // attaching data adapter to spinner
        spinSurat.setAdapter(dataAdapter);
        loadAyat(v);
    }

    private void loadAyat(View v){
        final View view_ = v;
        spinSurat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinAyat = view_.findViewById(R.id.spAyat);
                int jumlahAyat = listSuratTafsir.get(position).getJumlahAyat();
                ArrayList<String> ayat = new ArrayList<>();
                for (int i = 1; i <= jumlahAyat; i++){
                    ayat.add(String.valueOf(i));
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                        view.getContext(),
                        android.R.layout.simple_spinner_item,
                        ayat
                );
                spinAyat.setAdapter(dataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void search(){
        final View dialogView;

        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.search, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setTitle("Pilih surat dan ayat");
        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });
        dialog.setPositiveButton("Cari", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Spinner spinSurat = dialogView.findViewById(R.id.spSurat);
                Spinner spinAyat = dialogView.findViewById(R.id.spAyat);
                int scrollPosition = 0;

                for (SuratTafsir dataSurat : listSuratTafsir) {
                    if(dataSurat.getNamaLatin().equalsIgnoreCase(
                            spinSurat.getSelectedItem().toString())){
                        break;
                    }
                    scrollPosition += dataSurat.getJumlahAyat();
                }
                int position = scrollPosition + Integer.parseInt(spinAyat.getSelectedItem().toString()) - 1;
                recyclerViewTafsirTahili.scrollToPosition(position);
                recyclerViewTafsirWajiz.scrollToPosition(position);
                setSessionPage(position);

                tvSuraTitle.setText(spinSurat.getSelectedItem().toString());
            }
        });

        loadSurat(dialogView);

        dialog.show();
    }

    private void importDataToDatabase(){
        Cursor cursorRingkasKemenag, cursorTrans, cursorTahlili, cursorNamaSurat;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursorRingkasKemenag = db.rawQuery("SELECT * FROM ringkas_kemenag" , null);
        if(cursorRingkasKemenag.getCount() <= 0) {
            int ringkasKemenagResult = insertFromFile(this, R.raw.ringkas_kemenag);

            Log.d("info", "data yang ringkas_kemenag masook : " + ringkasKemenagResult );
        } else { }

        cursorTrans = db.rawQuery("SELECT * FROM trans" , null);
        if(cursorTrans.getCount() <= 0) {
            int transResult = insertFromFile(this, R.raw.trans);

            Log.d("info", "data yang trans masook : " + transResult );
        } else { }

        cursorTahlili = db.rawQuery("SELECT * FROM tahlili" , null);
        if(cursorTahlili.getCount() <= 0) {
            int tahliliResult = insertFromFile(this, R.raw.tahlili);

            Log.d("info", "data yang tahlili masook : " + tahliliResult );
        } else { }

        cursorNamaSurat = db.rawQuery("SELECT * FROM namasurat" , null);
        if(cursorNamaSurat.getCount() <= 0) {
            int namaSuratResult = insertFromFile(this, R.raw.namasurat);

            Log.d("info", "data yang namasurat masook : " + namaSuratResult );
        } else { }
    }

    private void setSessionPage(int page){
        Preferences pref = new Preferences(getApplicationContext());
        pref.setPage(page);
    }

    private void jumpTo(List<TafsirWajizModel> dataTafsirWajiz){
        Preferences pref = new Preferences(getApplicationContext());
        int page = pref.getPage();
        Log.d("DEBUG", "jumpTo: " + page);
        if (page != 0) {
            tvSuraTitle.setText(dataTafsirWajiz.get(page).getSura());
            recyclerViewTafsirTahili.scrollToPosition(page);
            recyclerViewTafsirWajiz.scrollToPosition(page);
        } else {
            tvSuraTitle.setText(dataTafsirWajiz.get(0).getSura());
        }
    }
}
