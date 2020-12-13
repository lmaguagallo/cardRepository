package com.example.cardalm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelperModel extends SQLiteOpenHelper {
    public SQLiteHelperModel(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS vh_usuario(" +
                "id_user INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_user TEXT(60)," +
                "word_user TEXT(20)," +
                "passw_user TEXT(30))"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS vh_fabricante(" +
                "id_fabricante INTEGER PRIMARY KEY," +
                "nombre_fabricante TEXT(30)," +
                "pais TEXT(20))");

        db.execSQL("CREATE TABLE IF NOT EXISTS vh_vehiculo (" +
                "id_vehiculo INTEGER PRIMARY KEY," +
                "marca TEXT(20)," +
                "id_fabricante INTEGER," +
                "modelo TEXT(20)," +
                "anio INTEGER," +
                "cilindraje INTEGER," +
                "id_tipo_combustible TEXT(2)) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
