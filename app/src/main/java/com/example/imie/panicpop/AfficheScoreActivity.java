package com.example.imie.panicpop;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;

/**
 * Created by Valérie on 22/08/14.
 */
public class AfficheScoreActivity extends ListActivity {

    BDD bdd;
    Cursor cListeScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_score);

        bdd = new BDD();
        String[] colonnes = new String[] {
                "nom",
                "score"
        };
        int[] to = new int[] {
                android.R.id.text1,
                android.R.id.text2
        };
        bdd.open(this);
        cListeScores = bdd.getInfos();
        startManagingCursor(cListeScores);
        //CursorLoader();


        SimpleCursorAdapter adapter = new SimpleCursorAdapter (this,
                android.R.layout.activity_list_item,
                cListeScores,
                colonnes,
                to);
        setListAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        cListeScores.requery();
    }

}


