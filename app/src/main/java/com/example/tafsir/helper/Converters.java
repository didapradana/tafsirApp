package com.example.tafsir.helper;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<String> fromString(String str) {
        return (ArrayList) new Gson().fromJson(str, new TypeToken<ArrayList<String>>() {
        }.getType());
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> arrayList) {
        return new Gson().toJson((Object) arrayList);
    }
}
