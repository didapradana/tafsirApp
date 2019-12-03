package com.example.tafsir;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    Context context;

    private final String PREF_NAME = "TAFSIR_PREF";

    public Preferences(Context context) {
        super();
        this.context = context;
    }

    public void setPage(int page){
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.putInt("page", page);
        editor.commit();
    }

    public int getPage(){
        settings = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return  settings.getInt("page", 0);
    }
}
