package com.example.appreceotas009;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexaobd extends SQLiteOpenHelper {

    private static final String name = "bd.db";
    private  static final int version = 1;

    public Conexaobd(Context context ) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table categoria (id integer primary key autoincrement, " +
                "nomeCategoria varchar (50), descricao varchar (50))");
        db.execSQL("create table receita (id integer primary key autoincrement, " +
                "nomeReceita varchar (50), tempoPreparo varchar (50), rendimento varchar (20), ingredientes varchar (20), modoPreparo varchar (20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
