package com.example.imie.panicpop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valerie on 22/08/14.
 */
public class BDDHelper extends SQLiteOpenHelper {

    public BDDHelper(Context context) {
        super(context, "scores.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //On créé la table scores contenant un nom et un score
        db.execSQL("CREATE TABLE scores (_id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT NOT NULL, score TEXT NOT NULL)");

        //On ajoute des données initiales
        db.execSQL("INSERT INTO scores VALUES (1, 'valerie', '10')");
        db.execSQL("INSERT INTO scores VALUES (2, 'quentin', '20')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}

