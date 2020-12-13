package com.example.cardalm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BeanUser {

    SQLiteHelperModel sqlhelper;
    SQLiteDatabase db;

    public BeanUser(Context ctx) {
        sqlhelper = new SQLiteHelperModel(ctx, "carAlmacenDB.db",null,1);
        db = sqlhelper.getWritableDatabase();
    }

    public void AddUser(String nombre, String userr, String pssw) {
        db.execSQL("INSERT INTO vh_usuario(nombre_user,word_user,passw_user) VALUES (?,?,?)",
                new Object[] {nombre,userr,pssw} );
    }

}
