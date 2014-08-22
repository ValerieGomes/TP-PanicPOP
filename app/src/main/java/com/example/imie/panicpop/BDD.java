package com.example.imie.panicpop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Valerie on 22/08/14.
 */
public class BDD {

    BDDHelper helper;       // le helper pour l'ouverture/création
    SQLiteDatabase base;    // l'objet qui représente la base

    public void open (Context activity) throws SQLException {
        // créer ou ouvrir la base de données
        helper = new BDDHelper(activity);
        base = helper.getWritableDatabase();
    }

    public Cursor getInfos() {
        return base.rawQuery("SELECT _id, nom, score FROM scores", null);
    }

    public long createInfo(String nom, String score) {
        ContentValues values = new ContentValues();
        values.putNull("_id");
        values.put("nom", nom);
        values.put("score", score);
        return base.insert("scores", null, values);
    }

}

